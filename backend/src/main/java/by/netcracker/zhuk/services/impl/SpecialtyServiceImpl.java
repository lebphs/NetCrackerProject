package by.netcracker.zhuk.services.impl;

import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.repository.SpecialtyRepository;
import by.netcracker.zhuk.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    SpecialtyRepository specialtyRepository;

    @Override
    public List<SpecialtyEntity> getSpecialtiesByFacultyId(String facultyId) {
        return specialtyRepository.findSpecialtyByFacultyId(Integer.parseInt(facultyId));
    }

    @Override
    public SpecialtyEntity findById(Integer id) {
        return specialtyRepository.findById(id);
    }


    @Override
    public void addSpecialty(SpecialtyEntity specialtyEntity) {
        specialtyRepository.save(specialtyEntity);
    }

    @Override
    public List<SpecialtyEntity> findAll() {
        return (List<SpecialtyEntity>) specialtyRepository.findAll();
    }

    @Override
    public SpecialtyEntity findByName(String name) {
        return specialtyRepository.findByName(name);
    }
}