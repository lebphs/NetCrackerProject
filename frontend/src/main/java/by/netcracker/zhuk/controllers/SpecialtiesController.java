package by.netcracker.zhuk.controllers;


import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.models.SpecialtyViewModel;
import by.netcracker.zhuk.models.StudentViewModel;
import by.netcracker.zhuk.services.FacultyService;
import by.netcracker.zhuk.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpecialtiesController {

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private FacultyService facultyService;


//    @RequestMapping(value = "/specialties", method = RequestMethod.GET)
//    @ResponseBody
//    public List<SpecialtyEntity> getSpecialties() {
//        return specialtyService.getAllSpecialties();//Todo create converters for view models
//    }

    @RequestMapping(value = "/specialties", method = RequestMethod.POST)
    @ResponseBody
    public SpecialtyViewModel getSpecialty(@RequestBody SpecialtyViewModel specialtyViewModel) {
        return specialtyViewModel;
    }

    @RequestMapping(value = "/specialtiesList", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialtyEntity> getSpecialtiesByFacultyId(@RequestParam("id") String facultyId) {
        //return specialtyService.getAllSpecialties();
        return specialtyService.getSpecialtiesByFacultyId(facultyId);//Todo create converters for view models
    }

    @RequestMapping(value = "/create-specialties", method = RequestMethod.POST)
    @ResponseBody
    public SpecialtyViewModel saveSpecialty(@RequestBody SpecialtyViewModel specialty) {
        SpecialtyEntity specialtyEntity = new SpecialtyEntity();
        specialtyEntity.setName(specialty.getName());
        specialtyEntity.setFaculty(facultyService.findById(specialty.getFacultyId()));
        specialtyService.addSpecialty(specialtyEntity);

        return specialty;//(List<StudentViewModel>) conversionService.convert(allstudents, studentEntityDescriptor, studentViewModelDescriptor);

    }


}