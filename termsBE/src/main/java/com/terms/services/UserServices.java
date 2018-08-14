package com.terms.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terms.config.EmailService;
import com.terms.config.FormatDate;
import com.terms.config.TokenCoder;
import com.terms.domen.MailInfo;
import com.terms.domen.User;
import com.terms.repository.RoleRepository;
import com.terms.repository.UserRepository;
import com.terms.resource.UserRest;
import com.terms.security.login.ResetKey;
import com.terms.services.interfaces.IUserService;
import com.terms.services.parseService.UpdateWithPatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class UserServices implements IUserService {

    private final Logger log = LoggerFactory.getLogger(UserRest.class);

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ResetKey resetKey;

    @Autowired
    EmailService emailService;

    @Autowired
    Environment environment;

    public UserServices(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /*
    *    @param Object User for create new
    */
    public User create(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setConfirmPasswordToken(ResetKey.generateRandomHexToken(50));
        user.setTokenExpirationDate(FormatDate.calculateExpiryDate(24 * 60));
        return this.userRepository.save(user);
    }


    /*
    *    @param Object User for check if exist user
    */
    @Transactional
    public User createAndUpdateUserAndSendMail(User user) throws RuntimeException {


        MailInfo mailInfo = new MailInfo(environment);
        ObjectMapper objectMapper = new ObjectMapper();

        String service = mailInfo.getProtocol() +
                mailInfo.getAddress() +
                mailInfo.getPort() +
                mailInfo.getConfirm();
        String content = mailInfo.getBody() + System.getProperty("line.separator");

        if (user.getId() != null) {
            log.info("PUT - SUCCESS - PUT USER -" + user.getUserName());
            User existsUser = this.updateUserPartial(user.getId(), objectMapper.convertValue(user, Map.class));
            return existsUser;
        } else {
            Map<String, Object> params = new HashMap<>();
            params.put("password", user.getPassword());
            User newUser = this.create(user);
            log.info("POST - SUCCESS - CREATED USER -" + user.getUserName());

            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(service)
                    .queryParam("id", newUser.getId())
                    .queryParam("key", TokenCoder.encode(newUser.getConfirmPasswordToken()))
                    .queryParam("type", "c");
            mailInfo.setMessage(uriComponentsBuilder.toUriString());
            mailInfo.setTo(newUser.getEmail());

            params.put("name", newUser.getFirstName() + " " + newUser.getLastName());
            params.put("username", newUser.getUserName());
            params.put("link", mailInfo.getMessage());

            String imageType = "image/png";
            String image = "logo1.png";
            String template = "mailTemplate";
            emailService.sendMailHtml(mailInfo, params, template, image, imageType, "create");

            return newUser;
        }
    }

    @Override
    @Transactional
    public User confirmUser(Long id, User user, String type) {

        Map<String, Object> params = new HashMap<>();

        if (type.equals("u")) {
            params.put("newPassword", null);
            params.put("password", user.getNewPassword());
        }
        params.put("active", true);
        params.put("tokenExpirationDate", null);
        params.put("confirmPasswordToken", null);
        params.put("lastPasswordResetDate", new Date());
        UpdateWithPatch updateWithPatch = new UpdateWithPatch(user, params);
        user = (User) updateWithPatch.getObject();
        user.setId(id);
        return this.updateUser(user);
    }

    @Override
    @Transactional
    public User updateUserPartial(Long id, Map<String, Object> params) {

        boolean changePass = false;
        User user = this.findOne(id);
        MailInfo mailInfo = new MailInfo(environment);
        ObjectMapper objectMapper = new ObjectMapper();

        String service = mailInfo.getProtocol() +
                mailInfo.getAddress() +
                mailInfo.getPort() +
                mailInfo.getConfirm();
        String content = mailInfo.getBody() + System.getProperty("line.separator");
        Map<String, Object> outParams = new HashMap<>();

        if (params.containsKey("password")) {

            outParams.put("password", bCryptPasswordEncoder.encode(params.get("password").toString()));
            outParams.put("confirmPasswordToken", TokenCoder.encode(ResetKey.generateRandomHexToken(50)));
            outParams.put("tokenExpirationDate", FormatDate.calculateExpiryDate(24 * 60));
            outParams.put("active", false);
            changePass = true;
        } else if (params.containsKey("newpassword")) {
            outParams.put("newPassword", bCryptPasswordEncoder.encode(params.get("newpassword").toString()));
            outParams.put("confirmPasswordToken", TokenCoder.encode(ResetKey.generateRandomHexToken(50)));
            outParams.put("tokenExpirationDate", FormatDate.calculateExpiryDate(24 * 60));
            outParams.put("active", false);
            changePass = true;
        }
        UpdateWithPatch updateWithPatch = new UpdateWithPatch(user, outParams);
        user = (User) updateWithPatch.getObject();
        user.setId(id);

        if (changePass) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(service)
                    .queryParam("id", user.getId())
                    .queryParam("key", TokenCoder.encode(user.getConfirmPasswordToken()))
                    .queryParam("type", "u");
            mailInfo.setMessage(uriComponentsBuilder.toUriString());
            mailInfo.setTo(user.getEmail());
            Map<String, Object> paramsMail = new HashMap<>();
            params.put("name", user.getFirstName() + " " + user.getLastName());
            params.put("username", user.getUserName());
            params.put("password", params.get("newpassword").toString());
            params.put("link", mailInfo.getMessage());

            String imageType = "image/png";
            String image = "logo1.png";
            String template = "mailTemplate";
            emailService.sendMailHtml(mailInfo, params, template, image, imageType, "update");


        }
        return this.updateUser(user);

    }

    @Override
    public User exists(User user) {
        return userRepository.findByUserName(user.getUserName());
    }

    /*
    *    @param
    *    @see - Get all users
    */

    public List<User> allUser() {
        return userRepository.findAll();
    }

    /*
    *    @param Object User for delete user
    */
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteAllById(id);
    }

    /*
   *
   * @id - find user by id param
   *
   */
    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    /*
   *
   * @userName - find user by username param
   *
   */
    @Override
    public User findOneByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User createUserByAdmin(User user) {

        if (user.getUser() == null) {
            user.setUser(userRepository.findUserByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
        }
        user.setAuthorities(roleRepository.findByNameRole("ROLE_CUSTOMER"));
        return this.create(user);
    }


    /*
    *   @param Object user for update all visible information
    */
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User findUserByIdAndKey(Long id, String key) {
        return userRepository.findAllByIdAndConfirmPasswordToken(id, key);
    }


    @Override
    public User checkExistsUserByParameter(Map<String, Object> param) {

        User user = null;
        if (param.containsKey("email")) {
            user = userRepository.findUserByEmail(param.get("email").toString());
        }
        if (param.containsKey("username")) {
            user = userRepository.findUserByUserName(param.get("username").toString());
        }
        return user;
    }

    /*
    *
    *  Delete all unconfirmed user
    */
    // @Scheduled(fixedDelayString = "${scheduler.delay}")
    @Transactional
    // @Named(value = "Delete users")
    public void deleteUnConfirmedUser() {
        Date date = new Date();
        userRepository.deleteAllByTokenExpirationDateLessThan(date);
        this.traceLog();
    }

    /*
    * @Print tracelog for current method
    * */
    private void traceLog() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        log.info("Task execute - " + stacktrace[2].toString());
    }


}


