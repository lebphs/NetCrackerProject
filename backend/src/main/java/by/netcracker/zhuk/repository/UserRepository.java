package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.entities.UserEntity;
import by.netcracker.zhuk.entities.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findByUsername(String firstName);
//    List<UserEntity> findByUsernameAndPassword(String firstName, String password);
//    List<UserEntity> findByRole(UserRoleEntity role);
    UserEntity findById(Integer id);
}
