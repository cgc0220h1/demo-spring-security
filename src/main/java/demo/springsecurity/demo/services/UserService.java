package demo.springsecurity.demo.services;

import demo.springsecurity.demo.model.Users;

import java.util.List;

public interface UserService {
    Users findUserByUsername(String username);

    Users addUsersToDB(Users users);

    List<Users> findAll();
}
