package com.stp.repository;

import com.stp.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer>{
}
