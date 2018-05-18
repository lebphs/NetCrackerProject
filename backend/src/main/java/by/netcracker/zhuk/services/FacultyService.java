package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.FacultyEntity;

import java.util.List;

public interface FacultyService {

    List<FacultyEntity> getAllFaculties();

    FacultyEntity findById(Integer facultyId);

    void addFaculty(FacultyEntity faculty);

    FacultyEntity findByName(String name);


}