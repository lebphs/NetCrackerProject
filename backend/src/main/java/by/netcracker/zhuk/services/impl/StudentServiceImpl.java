package by.netcracker.zhuk.services.impl;

import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.repository.StudentRepository;
import by.netcracker.zhuk.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentsRepository;

    @Override
    public List<StudentEntity> getAllStudents() {
        return (List<StudentEntity>) studentsRepository.findAll();
    }
}