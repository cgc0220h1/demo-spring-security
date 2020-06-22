package demo.springsecurity.demo.repositories;

import demo.springsecurity.demo.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UsersRepository extends PagingAndSortingRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
