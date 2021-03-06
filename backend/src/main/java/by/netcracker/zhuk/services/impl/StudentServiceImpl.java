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
    private StudentRepository studentRepository;

    @Override
    public List<StudentEntity> findAllStudents() {
        return (List<StudentEntity>) studentRepository.findAll();
    }


    @Override
    public void addStudent(StudentEntity studentEntity) {
        studentRepository.save(studentEntity);
    }


    @Override
    public void delete(String studentId) {
        studentRepository.delete(Integer.parseInt(studentId));
    }

    @Override
    public void delete(StudentEntity studentEntity) {
        studentRepository.delete(studentEntity);
    }


    @Override
    public StudentEntity findOne(String studentId) {
        return studentRepository.findOne(Integer.parseInt(studentId));
    }

    @Override
    public StudentEntity findBySurname(String surname) {
        return studentRepository.findBySurname(surname);
    }

    @Override
    public List<StudentEntity> findStudentByAvScoreAndSpecialty(double score, int idSpecialty) {
        return studentRepository.findStudentsByAvScoreAndSpecialty(score, idSpecialty);
    }
}