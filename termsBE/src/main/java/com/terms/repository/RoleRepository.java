package com.terms.repository;

import com.terms.domen.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vlatko on 23.2.18..
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findAllBy();
    Role findAllByNameRole(String nameRole);

    @Override
    List<Role> findAll();

    List<Role> findByNameRole(String nameRole);
}
