package by.netcracker.zhuk.services.impl;

import by.netcracker.zhuk.entities.UserRoleEntity;
import by.netcracker.zhuk.repository.UserRoleRepository;
import by.netcracker.zhuk.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRoleEntity findRoleByName(String name) {
        return userRoleRepository.findUserRoleEntityByName(name);
    }
}
