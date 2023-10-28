package Group3.demo.user.repository;

import org.springframework.data.repository.CrudRepository;

import Group3.demo.user.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String username);

    User findByEmail(String email);
}
