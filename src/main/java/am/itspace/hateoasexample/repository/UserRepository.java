package am.itspace.hateoasexample.repository;

import am.itspace.hateoasexample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
