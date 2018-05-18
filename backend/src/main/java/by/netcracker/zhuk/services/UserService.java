
package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.UserEntity;

import java.util.List;


public interface UserService {

    List<UserEntity> findUserByUserName(String name);

    UserEntity findUserById(String userId);

    void createUser(UserEntity userEntity);

}