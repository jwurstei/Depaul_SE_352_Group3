package Group3.demo.User.repository;

import Group3.demo.User.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User , Long>{
    User findByUserName(String username);
    User findByEmail(String email);
}
