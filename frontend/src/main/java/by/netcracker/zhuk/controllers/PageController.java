
package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.security.LoginUserService;
import by.netcracker.zhuk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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


    @RequestMapping(value = "/login-page", method = RequestMethod.GET)
    public ModelAndView getUsersAsModelWithView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_NAME_LOGIN);
//        modelAndView.addObject(MODEL_USERS, userService.findAllStudents());//Todo create converters for view models
        return modelAndView;
    }


}
