package by.netcracker.zhuk.controllers;


import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.models.SpecialtyViewModel;
import by.netcracker.zhuk.services.FacultyService;
import by.netcracker.zhuk.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SpecialtiesController {

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private ConversionService conversionService;


    @RequestMapping(value = "/specialties", method = RequestMethod.POST)
    @ResponseBody
    public SpecialtyViewModel getSpecialty(@RequestBody SpecialtyViewModel specialtyViewModel) {
        return specialtyViewModel;
    }

    @RequestMapping(value = "/specialtiesList", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialtyEntity> getSpecialtiesByFacultyId(@RequestParam("id") String facultyId) {
        return specialtyService.getSpecialtiesByFacultyId(facultyId);
    }

    @RequestMapping(value = "/create-specialties", method = RequestMethod.POST)
    @ResponseBody
    public SpecialtyViewModel saveSpecialty(@RequestBody SpecialtyViewModel specialty) {
        SpecialtyEntity specialtyEntity;
        if (specialtyService.findByName(specialty.getName()) != null) {
            specialtyEntity = new SpecialtyEntity();
        } else {
            specialtyEntity = conversionService.convert(specialty, SpecialtyEntity.class);
            specialtyService.addSpecialty(specialtyEntity);
        }
        return conversionService.convert(specialtyEntity, SpecialtyViewModel.class);

    }


}