
package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.converters.RequestEntityToRequestViewModelConverter;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.entities.UserEntity;
import by.netcracker.zhuk.models.RequestViewModel;
import by.netcracker.zhuk.models.StudentViewModel;
import by.netcracker.zhuk.security.LoginUserService;
import by.netcracker.zhuk.security.impl.CustomUser;
import by.netcracker.zhuk.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author anpi0316
 * Date: 10.04.2018
 */
@Controller
public class PageController {


    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;

    private static final String VIEW_NAME_LOGIN = "login";
    private static final String MODEL_USERS = "users";

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String goToHomePage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String redirectView = "redirect:/login-page";
        if (authentication != null) {
            redirectView = loginUserService.resolveHomeView(((List<GrantedAuthority>) authentication.getAuthorities()));
        }
        return redirectView;
    }

//    @RequestMapping(value = "/student-page", method = RequestMethod.GET)
//    public RequestViewModel getStudentAsModelWithView() {
//        CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserEntity userEntity = userService.findUserByUserName(customUser.getUsername()).get(0);
//        StudentEntity studentEntity = userEntity.getStudent();
//        System.out.println(studentEntity.getName());
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("students-page");
////
////        RequestEntityToRequestViewModelConverter requestConvert = new RequestEntityToRequestViewModelConverter();
////        modelAndView.addObject("student",conversionService.convert(studentEntity, StudentViewModel.class ));//Todo create converters for view models
////        modelAndView.addObject("practices", conversionService.convert(studentEntity.getRequestEntities(), RequestViewModel.class));
//        return conversionService.convert(requestEntity, Req.class);
//    }


    @RequestMapping(value = "/login-page", method = RequestMethod.GET)
    public ModelAndView getUsersAsModelWithView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_NAME_LOGIN);
//        modelAndView.addObject(MODEL_USERS, userService.findAllStudents());//Todo create converters for view models
        return modelAndView;
    }


}
