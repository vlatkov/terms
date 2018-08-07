package com.terms.resource;

import com.google.gson.Gson;
import com.terms.config.EmailService;
import com.terms.domen.User;
import com.terms.repository.RoleRepository;
import com.terms.repository.UserRepository;

import com.terms.services.UserServices;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping(value = "${api.path}",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class UserRest {

    private final Logger log = LoggerFactory.getLogger(UserRest.class);


    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserServices userServices;
    @Autowired
    EmailService emailService;
    @Autowired
    Environment environment;

    /*
    *   @param Create new User
    */
    @RequestMapping(value = "/register",
            method = RequestMethod.POST)
    ResponseEntity signUp(@RequestBody User user) {

        if (userServices.exists(user) == null) {
            Gson gson = new Gson();
            return ResponseEntity.ok(gson.toJson(userServices.createAndUpdateUserAndSendMail(user)));
        } else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    /*
    *   @Check exists username or email
    */
    @RequestMapping(value = "/check",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity checkExistsUser(@RequestBody Map<String, Object> param) {


        if (userServices.checkExistsUserByParameter(param) == null) {
            return ResponseEntity.ok(HttpStatus.OK.value());
        } else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    /*
    *   @Reset password
    */
    @RequestMapping(value = "/reset",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> resetPassword(@RequestBody Map<String,Object> params){
        User user = userServices.checkExistsUserByParameter(params);
        if (user != null){
        user = userServices.updateUserPartial(user.getId(), params);
        }
        return Optional.ofNullable(user)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /*
    *   @param Delete new User
    */
    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        log.info("DELETE user with params = " + id);
        userServices.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    /*
    *   @param Get user via ID
    */
    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long id){
        log.info("GET user with ID = " + id);
        User user = userServices.findOne(id);
        return Optional.ofNullable(user)
                .map(result -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/user/{id}",
                    method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user,
                                           @PathVariable Long id){
        log.info("PUT user with ID = " + user);

        User existUser = userServices.findOne(id);
        if(existUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(existUser.getId());
        userServices.updateUser(user);

        return Optional.ofNullable(user)
                .map(result -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/user/{userId}",
                    method = RequestMethod.PATCH)
    public ResponseEntity<User> updateUserPartial(@Valid @PathVariable Long userId,
                                                  @Valid @RequestBody Map<String,Object> userParams) throws IOException {
    log.info("PATCH user with ID = " + userId + " with params for update = " + userParams.toString());
    return Optional.ofNullable(userServices.updateUserPartial(userId,userParams))
            .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
