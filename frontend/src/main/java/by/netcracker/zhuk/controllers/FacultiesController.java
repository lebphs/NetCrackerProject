package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.models.Faculty;
import by.netcracker.zhuk.models.Student;
import by.netcracker.zhuk.models.UserViewModel;
import by.netcracker.zhuk.services.FacultyService;
import by.netcracker.zhuk.services.SpecialityService;
import by.netcracker.zhuk.services.StudentService;
import org.apache.commons.logging.impl.NoOpLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anpi0316
 *         Date: 04.03.2018
 *         Time: 14:44
 */
@Controller
public class FacultiesController {

    @Autowired()
    private FacultyService facultyService;


    private static final String VIEW_NAME_LOGIN = "adminPage";
    private static final String MODEL_USERS = "faculties";

//    @RequestMapping(value = "/admin-page", method = RequestMethod.GET)
//    public ModelAndView getUsersAsModelWithView() {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName(VIEW_NAME_LOGIN);
//        modelAndView.addObject(MODEL_USERS, facultyService.getAllFaculties());//Todo create converters for view models
//        return modelAndView;
//    }

    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyEntity> getFacultiesAsJson() {
        return facultyService.getAllFaculties();//Todo create converters for view models
    }

    @RequestMapping(value = "/faculties", method = RequestMethod.POST)
    @ResponseBody
    public Faculty getFaculties(@RequestBody Faculty faculty) {
        return faculty;
    }
}
