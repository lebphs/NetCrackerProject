package by.netcracker.zhuk.services.impl;

import by.netcracker.zhuk.entities.UserEntity;
import by.netcracker.zhuk.repository.UserRepository;
import by.netcracker.zhuk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findUserByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public UserEntity findUserById(String userId) {
        return userRepository.findById(Integer.parseInt(userId));
    }

    @Override
    public void createUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

}