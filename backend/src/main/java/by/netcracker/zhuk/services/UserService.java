
package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.UserEntity;

import java.util.List;


public interface UserService {

    List<UserEntity> findUserByUserName(String name);

    void createUsers(List<UserEntity> userEntity);

    List<UserEntity> findAllStudents();
}