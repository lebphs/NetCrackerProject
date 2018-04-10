package by.netcracker.zhuk.controllers;


import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.models.Specialty;
import by.netcracker.zhuk.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SpecialtiesController {

    @Autowired
    private SpecialtyService specialtyService;


//    @RequestMapping(value = "/specialties", method = RequestMethod.GET)
//    @ResponseBody
//    public List<SpecialtyEntity> getSpecialties() {
//        return specialtyService.getAllSpecialties();//Todo create converters for view models
//    }

    @RequestMapping(value = "/specialties", method = RequestMethod.POST)
    @ResponseBody
    public Specialty getSpecialty(@RequestBody Specialty specialty) {
        return specialty;
    }

    @RequestMapping(value = "/specialtiesList", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialtyEntity> getSpecialtiesByFacultyId(@RequestParam("id") String facultyId) {
        //return specialtyService.getAllSpecialties();
        return specialtyService.getSpecialtiesByFacultyId(facultyId);//Todo create converters for view models
    }


}