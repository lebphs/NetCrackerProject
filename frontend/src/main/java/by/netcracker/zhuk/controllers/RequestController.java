package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.entities.UserEntity;
import by.netcracker.zhuk.entities.UserRoleEntity;
import by.netcracker.zhuk.models.RequestViewModel;
import by.netcracker.zhuk.models.StudentViewModel;
import by.netcracker.zhuk.repository.UserRoleRepository;
import by.netcracker.zhuk.security.impl.CustomUser;
import by.netcracker.zhuk.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.*;

@Controller
public class RequestController {

    @Autowired
    SpecialtyService specialtyService;

    @Autowired
    UserService userService;

    @Autowired
    RequestService requestService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private StudentService studentService;




    private  final TypeDescriptor requestEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestEntity.class));
    private  final TypeDescriptor requestViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestViewModel.class));

    private  final TypeDescriptor requestEntityDescriptor1 = TypeDescriptor.collection(Set.class, TypeDescriptor.valueOf(RequestEntity.class));
    private  final TypeDescriptor requestViewModelDescriptor1 = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestViewModel.class));

    private  final TypeDescriptor studentEntityDescriptor = TypeDescriptor.collection(Set.class, TypeDescriptor.valueOf(StudentEntity.class));
    private  final TypeDescriptor studentViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));

    private static final String VIEW_NAME_LOGIN = "requestAllPage";
    private static final String MODEL_USERS = "students";

    @RequestMapping(value = "/request-page", method = RequestMethod.GET)
    public ModelAndView getUsersAsModelWithView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_NAME_LOGIN);
        //modelAndView.addObject(MODEL_USERS, studentService.getAllStudents());//Todo create converters for view models
        return modelAndView;
    }

    @RequestMapping(value = "/requestById", method = RequestMethod.GET)
    @ResponseBody
    public RequestEntity getRequestById(@RequestParam("id") String requestId) {
        return requestService.getRequestById(requestId);
//        List<RequestEntity> allrequest = requestService.findAllRequests();
//        return (List<RequestViewModel>) conversionService.convert(allrequest, requestEntityDescriptor, requestViewModelDescriptor);
    }

    @RequestMapping(value = "/create-request", method = RequestMethod.POST)
    @ResponseBody
    public List<RequestViewModel> saveStudents(@RequestBody RequestViewModel request) {

        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        String hashedPass = encoder.encodePassword(request.getPassword(), null);

        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setCompanyName(request.getCompanyName());
        //System.out.println(request.getStartDate());
        requestEntity.setStartDate(Date.valueOf(request.getStartDate()));
        requestEntity.setFinishDate(Date.valueOf(request.getFinishDate()));
        requestEntity.setSpecialty(specialtyService.findById(request.getSpecialtyId()));

        requestEntity.setTotalQuantity(request.getTotalQuantity());
        requestEntity.setMinAverageScore(request.getMinAverageScore());
        requestEntity.setStudentEntities(new HashSet<>());

        requestService.addRequest(requestEntity);


        UserRoleEntity role = userRoleRepository.findUserRoleEntityByName("head_of_practice");
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUser());
        userEntity.setPassword(hashedPass);
        userEntity.setRole(role);
        userEntity.setRequest(requestService.getRequestByName(request.getCompanyName()));
        userService.createUser(userEntity);

        //requestEntity.setUser(userService.findUserById(1));




        List<RequestEntity> allRequest = new ArrayList<RequestEntity>();
        allRequest.add(requestEntity);
        return (List<RequestViewModel>) conversionService.convert(allRequest, requestEntityDescriptor, requestViewModelDescriptor);

    }
    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    @ResponseBody
    public List<RequestViewModel> getAllRequests() {
        List<RequestEntity> allrequest = requestService.findAllRequests();
        return (List<RequestViewModel>) conversionService.convert(allrequest, requestEntityDescriptor, requestViewModelDescriptor);
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    @ResponseBody
    public List<RequestViewModel> getRequest() {
        //List<RequestEntity> allrequest = requestService.findAllRequests();
        CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.findUserByUserName(user.getUsername()).get(0);
        List<RequestEntity> request = new ArrayList<>();
        request.add(userEntity.getRequest());

        return ((List<RequestViewModel>) conversionService.convert(request, requestEntityDescriptor, requestViewModelDescriptor));
    }

    @RequestMapping(value = "/requestsForDropdownRealise", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getRequestDropdown(@RequestParam("id") String idStudent) {
        StudentEntity studentEntity = studentService.findOne(idStudent);
        Set<RequestEntity> requestDropdown  = studentEntity.getRequestEntities();
        return (List<StudentViewModel>) conversionService.convert(requestDropdown, requestEntityDescriptor1, requestViewModelDescriptor1);
    }

    @RequestMapping(value = "/requestsForDropdownAssign", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getRequestDropdownAssign(@RequestParam("id") String idStudent) {
        StudentEntity studentEntity = studentService.findOne(idStudent);
        List<RequestEntity> allRequest = requestService.findAllRequests();
        List<RequestEntity> requestDropdown  = new ArrayList<RequestEntity>();

        for (RequestEntity request: allRequest) {
            if(studentEntity.getSpecialityId().getId() == request.getSpecialty().getId() &&
                    request.getTotalQuantity() - request.getStudentEntities().size() > 0) {
                if (studentEntity.getAverageScore() >= request.getMinAverageScore()) {
                    requestDropdown.add(request);
                }
            }
        }
        return (List<StudentViewModel>) conversionService.convert(requestDropdown, requestEntityDescriptor, requestViewModelDescriptor);
    }


    @RequestMapping(value = "/personalPracticeStudentList", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getPersonalPracticeStudentList(@RequestParam String practiceId){
        RequestEntity requestEntity = requestService.getRequestById(practiceId);
        Set<StudentEntity> studentEntities = requestEntity.getStudentEntities();
        return (List<StudentViewModel>) conversionService.convert(studentEntities, studentEntityDescriptor, studentViewModelDescriptor);
    }

    @RequestMapping(value = "/requestForEdit", method = RequestMethod.GET)
    @ResponseBody
    public RequestViewModel getRequestForEdit(@RequestParam String requestId){
        RequestEntity requestEntity = requestService.getRequestById(requestId);
        return conversionService.convert(requestEntity, RequestViewModel.class);
    }
    @RequestMapping(value = "/editRequest", method = RequestMethod.POST)
    @ResponseBody
    public List<RequestViewModel> editRequest(@RequestBody RequestViewModel request){
        RequestEntity requestEntity = requestService.getRequestById(request.getId()+"");
        requestEntity.setTotalQuantity(request.getTotalQuantity());
        requestEntity.setStartDate(Date.valueOf(request.getStartDate()));
        requestEntity.setFinishDate(Date.valueOf(request.getFinishDate()));
        requestService.addRequest(requestEntity);

        List<RequestEntity> allRequest = requestService.findAllRequests();
        return (List<RequestViewModel>) conversionService.convert(allRequest, requestEntityDescriptor, requestViewModelDescriptor);
    }

    @RequestMapping(value = "/personalStudentPracticeList", method = RequestMethod.GET)
    @ResponseBody
    public List<RequestViewModel> getPersonalStudentPracticeList(@RequestParam String studentId){
        StudentEntity studentsEntity = studentService.findOne(studentId);
        Set<RequestEntity> requestEntities = studentsEntity.getRequestEntities();
        return (List<RequestViewModel>) conversionService.convert(requestEntities, requestEntityDescriptor1, requestViewModelDescriptor1);
    }

    @RequestMapping(value = "/delete-requests", method = RequestMethod.POST)
    @ResponseBody
    public void deleteStudents(@RequestBody String[] requestsId) {
        Set<StudentEntity> students;

        for (String id: requestsId) {
            RequestEntity requestEntity = requestService.getRequestById(id);
            students = requestEntity.getStudentEntities();
            for (StudentEntity student:students) {
                student.getRequestEntities().remove(requestEntity);
                studentService.addStudent(student);
            }
            requestService.delete(id);
        }
    }

//    @RequestMapping(value = "/assignStudents", method = RequestMethod.POST)
//    @ResponseBody
//    public RequestEntity getRequest(@RequestParam(required=false, name="id") String requestId) {
//        return requestService.getRequestById(requestId);
////        List<RequestEntity> allrequest = requestService.findAllRequests();
////        return (List<RequestViewModel>) conversionService.convert(allrequest, requestEntityDescriptor, requestViewModelDescriptor);
//    }

}
