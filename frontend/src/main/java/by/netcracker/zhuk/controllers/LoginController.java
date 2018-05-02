package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.entities.UserEntity;
import by.netcracker.zhuk.entities.UserRoleEntity;
import by.netcracker.zhuk.models.UserViewModel;
import by.netcracker.zhuk.repository.UserRepository;
import by.netcracker.zhuk.repository.UserRoleRepository;
import by.netcracker.zhuk.security.LoginUserService;
import by.netcracker.zhuk.security.impl.CustomUser;
import by.netcracker.zhuk.services.SpecialtyService;
import by.netcracker.zhuk.services.StudentService;
import by.netcracker.zhuk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class LoginController {


    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public void login(@RequestBody CustomUser loginData, HttpServletRequest request, HttpServletResponse response) {
        try {
            loginUserService.authenticateUserAndSetSession(loginData.getUsername(), loginData.getPassword(), request, response);
        } catch (BadCredentialsException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public void signUp(@RequestBody UserViewModel user, HttpServletRequest request, HttpServletResponse response) {
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        String hashedPass = encoder.encodePassword(user.getPassword(), null);
        List<UserEntity> usersEntities = userService.findUserByUserName(user.getSurname());

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setSurname(user.getSurname());
        studentEntity.setName(user.getName());
        studentEntity.setSpecialityId(specialtyService.findById(user.getSpecialtyId()));
        studentEntity.setGroup(user.getGroup());
        studentEntity.setIsBudget(user.getIsBudget());
        studentEntity.setAverageScore(user.getAverageScore());

        studentService.addStudent(studentEntity);


        //System.out.println(studentEntity.getIsBudget() +" "+ studentEntity.getAverageScore());

        UserEntity userEntity = new UserEntity();
        System.out.println(user.getSurname());
        userEntity.setUsername(user.getSurname());
        System.out.println(userEntity.getUsername());
        userEntity.setPassword(hashedPass);
        userEntity.setStudent(studentService.findOne("1"));

        System.out.println(userEntity.getStudent().getName());
        userEntity.setRole(userRoleRepository.findUserRoleEntityByName("student"));
        if(usersEntities.size() < 1) {
            userService.createUser(userEntity);

            loginUserService.authenticateUserAndSetSession(userEntity.getUsername(), user.getPassword(), request, response);
        }
    }
}
