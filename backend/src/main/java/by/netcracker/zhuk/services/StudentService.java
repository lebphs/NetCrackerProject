package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> findAllStudents();

    void addStudent(StudentEntity studentEntity);

    void delete(String studentId);

    void delete(StudentEntity studentEntity);

    StudentEntity findOne(String studentId);

    StudentEntity findBySurname(String surname);

    List<StudentEntity> findStudentByAvScoreAndSpecialty(double score, int idSpecialty);
}