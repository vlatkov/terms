package com.terms.services.parseService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
class UserFoundException extends RuntimeException {

    public UserFoundException(String userName) {

        super("User exists '" + userName + "'");
    }
}
