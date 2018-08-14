package com.terms.services.interfaces;


import com.terms.domen.User;

import java.util.Map;

public interface IUserService {

    User create(User user);

    User confirmUser(Long id, User user, String type);

    User createAndUpdateUserAndSendMail(User user);

    User updateUserPartial(Long id, Map<String, Object> params);

    User exists(User user);

    void deleteUser(Long id);

    User findOne(Long id);

    User updateUser(User user);

    User findUserByIdAndKey(Long id, String key);

    User checkExistsUserByParameter(Map<String, Object> param);

    User findOneByUserName(String userName);

    User createUserByAdmin(User user);
}
