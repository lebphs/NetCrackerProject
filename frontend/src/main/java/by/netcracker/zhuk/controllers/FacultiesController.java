package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.models.FacultyViewModel;
import by.netcracker.zhuk.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public FacultyViewModel getFaculties(@RequestBody FacultyViewModel facultyViewModel) {
        return facultyViewModel;
    }
}
