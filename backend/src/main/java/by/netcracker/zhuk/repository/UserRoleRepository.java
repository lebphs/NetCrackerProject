package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserEntity, Integer> {

}
