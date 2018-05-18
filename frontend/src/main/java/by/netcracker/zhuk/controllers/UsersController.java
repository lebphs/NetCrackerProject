package by.netcracker.zhuk.controllers;


import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.entities.UserEntity;
import by.netcracker.zhuk.models.StudentViewModel;
import by.netcracker.zhuk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UserService userService;

    @Autowired
    private ConversionService conversionService;


    @RequestMapping(value = "/studentByName", method = RequestMethod.GET)
    @ResponseBody
    public StudentViewModel getUsersAsJson(@RequestParam String name) {
        List<UserEntity> userEntity = userService.findUserByUserName(name);
        StudentEntity studentEntity = userEntity.get(0).getStudent();
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setId(studentEntity.getId());
        studentEntity.setSurname(studentEntity.getSurname());
        return studentViewModel;
    }
}

