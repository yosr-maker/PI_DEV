package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.User;

@Repository
public interface UserRepository  extends CrudRepository<User,Long>{



}
