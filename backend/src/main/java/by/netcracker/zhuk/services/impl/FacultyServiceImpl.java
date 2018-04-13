package by.netcracker.zhuk.services.impl;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.repository.FacultyRepository;
import by.netcracker.zhuk.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<FacultyEntity> getAllFaculties() {
        return (List<FacultyEntity>) facultyRepository.findAll();
    }

    @Override
    public FacultyEntity findById(Integer facultyId){
        return (FacultyEntity) facultyRepository.findById(facultyId);
    }

    @Override
    public void addFaculty(FacultyEntity facultyEntities) {
        facultyRepository.save(facultyEntities);
    }

}