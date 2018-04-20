package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.models.RequestViewModel;
import by.netcracker.zhuk.models.StudentViewModel;
import by.netcracker.zhuk.repository.FacultyRepository;
import by.netcracker.zhuk.repository.SpecialtyRepository;
import by.netcracker.zhuk.repository.UserRepository;
import by.netcracker.zhuk.services.RequestService;
import by.netcracker.zhuk.services.SpecialtyService;
import by.netcracker.zhuk.services.StudentService;
import by.netcracker.zhuk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    private StudentService studentService;

    private  final TypeDescriptor requestEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestEntity.class));
    private  final TypeDescriptor requestViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestViewModel.class));

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

        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setCompanyName(request.getCompanyName());
        System.out.println(request.getStartDate());
        requestEntity.setStartDate(Date.valueOf(request.getStartDate()));
        requestEntity.setFinishDate(Date.valueOf(request.getFinishDate()));
        requestEntity.setSpecialty(specialtyService.findById(request.getSpecialtyId()));

        requestEntity.setTotalQuantity(request.getTotalQuantity());
        requestEntity.setMinAverageScore(request.getMinAverageScore());
        //requestEntity.setUser(userService.findUserById(1));

        requestService.addRequest(requestEntity);


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

//    @RequestMapping(value = "/assignStudents", method = RequestMethod.POST)
//    @ResponseBody
//    public RequestEntity getRequest(@RequestParam(required=false, name="id") String requestId) {
//        return requestService.getRequestById(requestId);
////        List<RequestEntity> allrequest = requestService.findAllRequests();
////        return (List<RequestViewModel>) conversionService.convert(allrequest, requestEntityDescriptor, requestViewModelDescriptor);
//    }

}
