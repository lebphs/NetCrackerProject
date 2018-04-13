package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.models.StudentViewModel;
import by.netcracker.zhuk.services.SpecialtyService;
import by.netcracker.zhuk.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    SpecialtyService specialtyService;

    @Autowired
    private ConversionService conversionService;

    private  final TypeDescriptor studentEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentEntity.class));
    private  final TypeDescriptor studentViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));


    private static final String VIEW_NAME_LOGIN = "adminPage";
    private static final String MODEL_USERS = "students";


    @RequestMapping(value = "/admin-page", method = RequestMethod.GET)
    public ModelAndView getUsersAsModelWithView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_NAME_LOGIN);
        //modelAndView.addObject(MODEL_USERS, studentService.getAllStudents());//Todo create converters for view models
        return modelAndView;
    }

//    @RequestMapping(value = "/students", method = RequestMethod.GET)
//    @ResponseBody
//    public List<StudentEntity> getUsersAsJson() {
//        return studentService.getAllStudents();//Todo create converters for view models
//    }
    @RequestMapping(value = "/studentsForTable", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getAllStudents() {
        List<StudentEntity> allstudents = studentService.findAllStudents();
        return (List<StudentViewModel>) conversionService.convert(allstudents, studentEntityDescriptor, studentViewModelDescriptor);
    }

    @RequestMapping(value = "/create-student", method = RequestMethod.POST)
    @ResponseBody
    public List<StudentViewModel> saveStudents(@RequestBody StudentViewModel student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setSurname(student.getSurname());
        studentEntity.setName(student.getName());
        studentEntity.setSpecialityId(specialtyService.findById(student.getSpecialtyId()));
        studentEntity.setGroup(student.getGroup());
        studentEntity.setIsBudget(student.getIsBudget());
        studentEntity.setAverageScore(student.getAverageScore());
        studentService.addStudent(studentEntity);

        List<StudentEntity> allstudents = new ArrayList<StudentEntity>();
        allstudents.add(studentEntity);
        return (List<StudentViewModel>) conversionService.convert(allstudents, studentEntityDescriptor, studentViewModelDescriptor);

    }

    @RequestMapping(value = "/delete-students", method = RequestMethod.POST)
    @ResponseBody
    public void deleteStudents(@RequestBody String[] studentId) {
//        System.out.println(studentId.toString());
        for (String id: studentId) {
            studentService.delete(id);
        }


    }
}