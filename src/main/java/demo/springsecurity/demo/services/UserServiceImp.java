package demo.springsecurity.demo.services;

import demo.springsecurity.demo.model.Users;
import demo.springsecurity.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UsersRepository usersRepository;

    @Autowired
    public UserServiceImp(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users findUserByUsername(String username) {
        return usersRepository.findByUsername(username).orElse(null);
    }

    @Override
    public Users addUsersToDB(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public List<Users> findAll() {
        List<Users> usersList = new LinkedList<>();
        for (Users users : usersRepository.findAll()) {
            usersList.add(users);
        }
        return usersList;
    }
}
