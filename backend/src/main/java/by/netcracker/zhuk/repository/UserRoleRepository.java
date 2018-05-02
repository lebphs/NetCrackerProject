package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.entities.UserEntity;
import by.netcracker.zhuk.entities.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Integer> {
    UserRoleEntity findUserRoleEntityByName(String name);
}
