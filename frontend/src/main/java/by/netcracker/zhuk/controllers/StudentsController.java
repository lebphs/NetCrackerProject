package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.converters.RequestEntityToRequestViewModelConverter;
import by.netcracker.zhuk.converters.StudentEntityToStudentViewModelConverter;
import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.entities.UserEntity;
import by.netcracker.zhuk.models.RequestViewModel;
import by.netcracker.zhuk.models.StudentViewModel;
import by.netcracker.zhuk.security.impl.CustomUser;
import by.netcracker.zhuk.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    SpecialtyService specialtyService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentPagingAndSortingService studentPagingAndSortingService;

    @Autowired
    private ConversionService conversionService;

    private  final TypeDescriptor studentEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentEntity.class));
    private  final TypeDescriptor studentViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));

    private  final TypeDescriptor studentEntityDescriptor1 = TypeDescriptor.collection(Set.class, TypeDescriptor.valueOf(StudentEntity.class));
    private  final TypeDescriptor studentViewModelDescriptor1 = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));

    private  final TypeDescriptor requestEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestEntity.class));
    private  final TypeDescriptor requestViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestViewModel.class));


    private  final TypeDescriptor requestEntityDescriptor1 = TypeDescriptor.collection(Set.class, TypeDescriptor.valueOf(RequestEntity.class));
    private  final TypeDescriptor requestViewModelDescriptor1 = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestViewModel.class));

    private static final String VIEW_NAME_LOGIN = "admin-page";
    private static final String MODEL_USERS = "student";


//    @RequestMapping(value = "/admin-page", method = RequestMethod.GET)
//    public ModelAndView getUsersAsModelWithView() {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName(VIEW_NAME_LOGIN);
//        //modelAndView.addObject(MODEL_USERS, studentService.getAllStudents());//Todo create converters for view models
//        return modelAndView;
//    }

    @RequestMapping(value = "/studentTable", method = RequestMethod.GET)
    @ResponseBody
    public StudentViewModel getStudentAsModelWithView() {
        CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.findUserByUserName(customUser.getUsername()).get(0);
        StudentEntity studentEntity = userEntity.getStudent();
        //ModelAndView modelAndView = new ModelAndView();
        //.setViewName("student-page");

        //RequestEntityToRequestViewModelConverter requestConvert = new RequestEntityToRequestViewModelConverter();
        return conversionService.convert(studentEntity, StudentViewModel.class );//Todo create converters for view models
        //modelAndView.addObject("practices", conversionService.convert(studentEntity.getRequestEntities(), requestEntityDescriptor1, requestViewModelDescriptor));
    }
//    @RequestMapping(value = "/info-page", method = RequestMethod.GET)
//    public ModelAndView getStudentAsModelWithView(@RequestParam String studentId) {
//        StudentEntity studentEntity = studentService.findOne(studentId);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("student-page");
//
//        modelAndView.addObject("student",conversionService.convert(studentEntity, StudentViewModel.class ));
//        modelAndView.addObject("practices", conversionService.convert(studentEntity.getRequestEntities(), requestEntityDescriptor1, requestViewModelDescriptor));
//        return modelAndView;
//    }
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


    @RequestMapping(value = "/studentsForTable", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getAllStudents() {
        List<StudentEntity> allstudents = studentService.findAllStudents();
        return (List<StudentViewModel>) conversionService.convert(allstudents, studentEntityDescriptor, studentViewModelDescriptor);
    }

    @RequestMapping(value ="/studentsTable", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap getStudentTable(@RequestParam String search, @RequestParam String sort, @RequestParam String order, @RequestParam Integer offset, @RequestParam Integer limit){
        ModelMap model = new ModelMap();
        List<StudentEntity> studentEntities = studentPagingAndSortingService.getPagingAndSortedStudent(search, sort, order, offset, limit);
        List<StudentViewModel> list = (List<StudentViewModel>) conversionService.convert(studentEntities, studentEntityDescriptor,studentViewModelDescriptor1);
        model.addAttribute("rows", list);
        model.addAttribute("total", studentService.findAllStudents().size());
        return model;
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
        StudentEntity studentEntity;
        Set<RequestEntity> requestEntities;
        for (String id: studentId) {
            studentEntity = studentService.findOne(id);
            requestEntities = studentEntity.getRequestEntities();
            for(RequestEntity requestEntity: requestEntities){
                realiseStudent(id, requestEntity);
                requestService.addRequest(requestEntity);
            }
            studentService.delete(id);
        }
    }

    @RequestMapping(value = "/studentsForDropdownAssign", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getRequestDropdownAssign(@RequestParam("id") String idRequest) {
        RequestEntity requestEntity = requestService.getRequestById(idRequest);
        List<StudentEntity> allStudents = studentService.findAllStudents();
        List<StudentEntity> studentDropdown  = new ArrayList<StudentEntity>();

        for (StudentEntity student: allStudents) {
            if(requestEntity.getSpecialty().getId() == student.getSpecialityId().getId() &&
                    requestEntity.getTotalQuantity() - requestEntity.getStudentEntities().size() > 0) {
                if (student.getAverageScore() >= requestEntity.getMinAverageScore()) {
                    studentDropdown.add(student);
                    System.out.println(student.getName());
                }
            }
        }
        return (List<StudentViewModel>) conversionService.convert(studentDropdown, studentEntityDescriptor, studentViewModelDescriptor);
    }

    @RequestMapping(value = "/assign-students", method = RequestMethod.POST)
    @ResponseBody
    public List<StudentViewModel> assignStudents(@RequestBody StudentViewModel req) {
        assign(req);
        List<StudentEntity> allStudents = studentService.findAllStudents();
        return (List<StudentViewModel>) conversionService.convert(allStudents, studentEntityDescriptor, studentViewModelDescriptor);
    }

    @RequestMapping(value = "/assignStudentPage", method = RequestMethod.POST)
    @ResponseBody
    public List<RequestViewModel> assignStudentPage(@RequestBody StudentViewModel req) {
        assign(req);
        Set<RequestEntity> requests = new HashSet<>();
        for(String id: req.getRequestsList()){
            requests.add(requestService.getRequestById(id));
        }

        return (List<RequestViewModel>) conversionService.convert(requests, requestEntityDescriptor1, requestViewModelDescriptor);
    }

    @RequestMapping(value = "/assign-student-requestPage", method = RequestMethod.POST)
    @ResponseBody
    public List<RequestViewModel> assignStudent(@RequestBody StudentViewModel req) {
        assign(req);
        List<RequestEntity> allRequest = requestService.findAllRequests();
        return (List<RequestViewModel>) conversionService.convert(allRequest, requestEntityDescriptor, requestViewModelDescriptor);
    }

    private void assign(StudentViewModel req){
        RequestEntity requestEntity = requestService.getRequestById(req.getRequestsList().get(0));
        int quantity = requestEntity.getTotalQuantity();

        if (quantity - requestEntity.getStudentEntities().size() > 0){
            for (String id : req.getStudentsList()) {
                StudentEntity studentEntity = studentService.findOne(id);
                studentEntity.setStudentStatus("Waiting for practice");
                studentEntity.getRequestEntities().add(requestEntity);
                studentService.addStudent(studentEntity);
                //requestEntity.getStudentEntities().add(studentEntity);
            }
            requestService.addRequest(requestEntity);
        }
    }

    @RequestMapping(value = "/realise-students", method = RequestMethod.POST)
    @ResponseBody
    public List<StudentViewModel> realiseStudents(@RequestBody StudentViewModel req) {

        RequestEntity requestEntity = requestService.getRequestById(req.getRequestsList().get(0));

        //int quantity = requestEntity.getTotalQuantity();

        for (String id: req.getStudentsList()) {
            realiseStudent(id, requestEntity);
            //requestEntity.getStudentEntities().add(studentEntity);
        }
        requestService.addRequest(requestEntity);

        List<StudentEntity> allStudents = studentService.findAllStudents();
        return (List<StudentViewModel>) conversionService.convert(allStudents, studentEntityDescriptor, studentViewModelDescriptor);
    }

    private void realiseStudent(String id, RequestEntity requestEntity){
        StudentEntity studentEntity = studentService.findOne(id);
        studentEntity.setStudentStatus("Not allocated");
        studentEntity.getRequestEntities().remove(requestEntity);
        studentService.addStudent(studentEntity);


    }

}