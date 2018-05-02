package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.UserRoleEntity;

public interface UserRoleService {
    UserRoleEntity findRoleByName(String name);
}
