package com.terms.repository;

import com.terms.domen.User;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);
    List<User> findAllByActive(boolean active);
    User findAllByUserNameAndActive(String username, boolean active);
    User findUserByEmailAndActive(String email, boolean active);
    User findUserByEmail(String email);
    User findUserByUserName(String username);
    User findAllByIdAndConfirmPasswordToken(Long userId, String resetKey);
    User findAllByEmail(String email);
    void deleteAllById(Long id);
    void deleteAllByTokenExpirationDateLessThan(Date date);

}
