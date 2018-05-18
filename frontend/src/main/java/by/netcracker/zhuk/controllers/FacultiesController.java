package by.netcracker.zhuk.controllers;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.models.FacultyViewModel;
import by.netcracker.zhuk.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
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

    @Autowired
    private ConversionService conversionService;

    private final TypeDescriptor facultyEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyEntity.class));
    private final TypeDescriptor facultyViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyViewModel.class));


    private static final String VIEW_NAME_LOGIN = "adminPage";
    private static final String MODEL_USERS = "faculties";


    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyEntity> getFacultiesAsJson() {
        return (List<FacultyEntity>) conversionService.convert(facultyService.getAllFaculties(), facultyEntityDescriptor, facultyViewModelDescriptor);
    }

    @RequestMapping(value = "/create-faculty", method = RequestMethod.POST)
    @ResponseBody
    public FacultyViewModel saveSpecialty(@RequestBody FacultyViewModel faculty) {
        FacultyEntity facultyEntity;
        if (facultyService.findByName(faculty.getName()) == null) {
            facultyEntity = conversionService.convert(faculty, FacultyEntity.class);
            facultyService.addFaculty(facultyEntity);
        } else {
            facultyEntity = new FacultyEntity();
        }
        return conversionService.convert(facultyEntity, FacultyViewModel.class);

    }
}
