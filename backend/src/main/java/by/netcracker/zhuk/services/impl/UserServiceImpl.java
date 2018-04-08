//package by.netcracker.zhuk.services.impl;
//
//import by.netcracker.zhuk.entities.UserEntity;
//import by.netcracker.zhuk.entities.UserRoleEntity;
//import by.netcracker.zhuk.repository.UserRepository;
//import by.netcracker.zhuk.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//
//@Transactional
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private static final UserRoleEntity USER_ROLE_STUDENT = UserRole.toString(); //do create enum with roles
//
//    @Override
//    public List<UserEntity> findUserByUserName(String name) {
//        return userRepository.findByUsername(name);
//    }
//
//    @Override
//    public void createUsers(List<UserEntity> userEntity) {
//        userRepository.save(userEntity);
//    }
//
//    public List<UserEntity> findAllStudents() {
//        return userRepository.findByRole(USER_ROLE_STUDENT);
//    }
//}