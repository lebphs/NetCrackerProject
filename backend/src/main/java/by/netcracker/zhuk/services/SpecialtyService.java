package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.SpecialtyEntity;

import java.util.List;


public interface SpecialtyService {

    List<SpecialtyEntity> getSpecialtiesByFacultyId(String facultyId);

    SpecialtyEntity findById(Integer id);

    SpecialtyEntity findByName(String name);

    void addSpecialty(SpecialtyEntity specialtyEntity);

    List<SpecialtyEntity> findAll();
}
