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


@Controller
public class FacultiesController {

    @Autowired()
    private FacultyService facultyService;


    private static final String VIEW_NAME_LOGIN = "adminPage";
    private static final String MODEL_USERS = "faculties";


    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyEntity> getFacultiesAsJson() {
        return facultyService.getAllFaculties();//Todo create converters for view models
    }

    @RequestMapping(value = "/create-faculty", method = RequestMethod.POST)
    @ResponseBody
    public FacultyViewModel saveSpecialty(@RequestBody FacultyViewModel faculty) {
        FacultyEntity specialtyEntity = new FacultyEntity();
        specialtyEntity.setName(faculty.getName());
        facultyService.addFaculty(specialtyEntity);

        return faculty;//(List<StudentViewModel>) conversionService.convert(allstudents, studentEntityDescriptor, studentViewModelDescriptor);

    }
}
