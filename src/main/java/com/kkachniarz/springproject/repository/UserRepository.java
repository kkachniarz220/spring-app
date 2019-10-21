package com.kkachniarz.springproject.repository;

import com.kkachniarz.springproject.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
