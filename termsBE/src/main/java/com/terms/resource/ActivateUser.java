package com.terms.resource;


import com.terms.config.TokenCoder;
import com.terms.domen.MailInfo;
import com.terms.domen.User;
import com.terms.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
public class ActivateUser {

    private final Logger log = LoggerFactory.getLogger(UserRest.class);

    @Autowired
    MailInfo mailInfo;

    @Autowired
    private UserServices userServices;

    @RequestMapping(value = "/confirm")
    public ResponseEntity<?> activateUser(@RequestParam Long id, @RequestParam String key) throws URISyntaxException {

        log.info("POST user with ID = " + id + " with params for update - RESETKEY " + key);

        User user = userServices.findUserByIdAndKey(id, TokenCoder.decode(key));
        URI url = new URI(mailInfo.getAfterConfirmLoginUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(url);

        return Optional.ofNullable(userServices.confirmUser(id, user))
                .map(result -> new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/reset")
    public ResponseEntity<User> resetPasswordUser(@PathVariable Long id, @RequestBody User user) throws IOException {

        log.info("PUT user with username = ", user.getUserName());
        User existsUser = userServices.findOne(id);
        user.setId(existsUser.getId());
        if (userServices.createAndUpdateUserAndSendMail(user) != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
