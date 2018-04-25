package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.converters.RequestEntityToRequestViewModelConverter;
import by.netcracker.zhuk.converters.StudentEntityToStudentViewModelConverter;
import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.models.RequestViewModel;
import by.netcracker.zhuk.models.StudentRequestViewModel;
import by.netcracker.zhuk.models.StudentViewModel;
import by.netcracker.zhuk.services.RequestService;
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
import java.util.Set;

@Controller
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    SpecialtyService specialtyService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private ConversionService conversionService;

    private  final TypeDescriptor studentEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentEntity.class));
    private  final TypeDescriptor studentViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));


    private  final TypeDescriptor requestEntityDescriptor = TypeDescriptor.collection(Set.class, TypeDescriptor.valueOf(RequestEntity.class));
    private  final TypeDescriptor requestViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestViewModel.class));

    private static final String VIEW_NAME_LOGIN = "admin-page";
    private static final String MODEL_USERS = "student";


    @RequestMapping(value = "/admin-page", method = RequestMethod.GET)
    public ModelAndView getUsersAsModelWithView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_NAME_LOGIN);
        //modelAndView.addObject(MODEL_USERS, studentService.getAllStudents());//Todo create converters for view models
        return modelAndView;
    }

    @RequestMapping(value = "/student-page", method = RequestMethod.GET)
    public ModelAndView getStudentAsModelWithView(@RequestParam String studentId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student-page");
        StudentEntity student = studentService.findOne(studentId);
        StudentEntityToStudentViewModelConverter converter = new StudentEntityToStudentViewModelConverter();

        RequestEntityToRequestViewModelConverter requestConvert = new RequestEntityToRequestViewModelConverter();
        modelAndView.addObject(MODEL_USERS,converter.convert(student));//Todo create converters for view models
        modelAndView.addObject("practices", conversionService.convert(student.getRequestEntities(),requestEntityDescriptor, requestViewModelDescriptor));
        return modelAndView;
    }
//
//    @RequestMapping(value = "/studentInfo", method = RequestMethod.GET)
//    @ResponseBody
//    public List<StudentViewModel> getStudentInfo(@RequestParam String studentId){
//        StudentEntity studentEntity = studentService.findOne(studentId);
//        List<StudentEntity> studentsEntity = new ArrayList<>();
//        studentsEntity.add(studentEntity);
//        //Set<RequestEntity> requestEntities = studentsEntity.getRequestEntities();
//        return (List<StudentViewModel>) conversionService.convert(studentsEntity, studentEntityDescriptor, studentViewModelDescriptor);
//    }

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

    @RequestMapping(value = "/studentsForMultiselect", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getStudentsMultiselect(@RequestParam("id") String idRequest) {
        RequestEntity requestEntity = requestService.getRequestById(idRequest);
        List<StudentEntity> allstudents = studentService.findAllStudents();
        List<StudentEntity> studentMultiselect = new ArrayList<StudentEntity>();
        for (StudentEntity student: allstudents) {
            if((student.getSpecialityId()).equals(requestEntity.getSpecialty())) {
                if (student.getAverageScore() >= requestEntity.getMinAverageScore()) {
                    studentMultiselect.add(student);
                }
            }
        }
        return (List<StudentViewModel>) conversionService.convert(studentMultiselect, studentEntityDescriptor, studentViewModelDescriptor);
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

    @RequestMapping(value = "/assign-students", method = RequestMethod.POST)
    @ResponseBody
    public List<StudentViewModel> assignStudents(@RequestBody StudentRequestViewModel req) {
        RequestEntity requestEntity = requestService.getRequestById(req.getIdRequest());
        int quantity = requestEntity.getTotalQuantity();

        if (quantity - requestEntity.getStudentEntities().size() > 0){
            for (String id : req.getIdStudents()) {
                StudentEntity studentEntity = studentService.findOne(id);
                studentEntity.setStudentStatus("Waiting for practice");
                studentEntity.getRequestEntities().add(requestEntity);
                studentService.addStudent(studentEntity);
                //requestEntity.getStudentEntities().add(studentEntity);
            }
        requestService.addRequest(requestEntity);
        }

        List<StudentEntity> allStudents = studentService.findAllStudents();
        return (List<StudentViewModel>) conversionService.convert(allStudents, studentEntityDescriptor, studentViewModelDescriptor);
    }

    @RequestMapping(value = "/realise-students", method = RequestMethod.POST)
    @ResponseBody
    public List<StudentViewModel> realiseStudents(@RequestBody StudentRequestViewModel req) {
        System.out.println(req.getIdRequest() + " " + req.getIdStudents());
        RequestEntity requestEntity = requestService.getRequestById(req.getIdRequest());
        int quantity = requestEntity.getTotalQuantity();

        for (String id: req.getIdStudents()) {
            StudentEntity studentEntity = studentService.findOne(id);
            studentEntity.setStudentStatus("Not allocated");
            studentEntity.getRequestEntities().remove(requestEntity);
            studentService.addStudent(studentEntity);
            //requestEntity.getStudentEntities().add(studentEntity);
        }
        requestService.addRequest(requestEntity);

        List<StudentEntity> allStudents = studentService.findAllStudents();
        return (List<StudentViewModel>) conversionService.convert(allStudents, studentEntityDescriptor, studentViewModelDescriptor);
    }

}