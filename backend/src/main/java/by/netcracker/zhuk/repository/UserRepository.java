package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findByUsername(String firstName);

    UserEntity findById(Integer id);
}
