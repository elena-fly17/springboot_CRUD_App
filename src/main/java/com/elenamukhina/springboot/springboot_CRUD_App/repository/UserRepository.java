package com.elenamukhina.springboot.springboot_CRUD_App.repository;

import com.elenamukhina.springboot.springboot_CRUD_App.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
