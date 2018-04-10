package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.models.Student;
import by.netcracker.zhuk.services.SpecialtyService;
import by.netcracker.zhuk.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    SpecialtyService specialtyService;


    private static final String VIEW_NAME_LOGIN = "adminPage";
    private static final String MODEL_USERS = "students";


    @RequestMapping(value = "/admin-page", method = RequestMethod.GET)
    public ModelAndView getUsersAsModelWithView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_NAME_LOGIN);
        modelAndView.addObject(MODEL_USERS, studentService.getAllStudents());//Todo create converters for view models
        return modelAndView;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentEntity> getUsersAsJson() {
        return studentService.getAllStudents();//Todo create converters for view models
    }

    @RequestMapping(value = "/create-students", method = RequestMethod.POST)
    @ResponseBody
    public void saveStudents(@RequestBody Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setSurname(student.getSurname());
        studentEntity.setName(student.getName());
        studentEntity.setSpecialityId(specialtyService.findById(1));
        studentEntity.setGroup(student.getGroup());
        studentEntity.setIsBudget(student.getIsBudget());
        studentEntity.setAverageScore(student.getAverageScore());
        studentService.addStudent(studentEntity);

    }
    @RequestMapping(value = "/delete-students", method = RequestMethod.GET)
    @ResponseBody
    public void saveStudents(@RequestParam("id") String studentId) {
        studentService.delete(studentId);

    }
}