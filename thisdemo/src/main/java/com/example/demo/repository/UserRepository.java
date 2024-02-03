package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls,Integer> {
    

  ///it contain all the method to save etc

  //it is used to check no repeatation of email
  public boolean existsByEmail(String email);
}
