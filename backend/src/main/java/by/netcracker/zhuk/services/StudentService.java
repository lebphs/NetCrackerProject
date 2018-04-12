package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> findAllStudents();
    void addStudent(StudentEntity studentEntity);
    void delete(String studentId);
//    int getIdLastCreatedStudent();
    StudentEntity findOne(String studentId);
//    void editStudent(String surname, String name, String patronymic, Integer specialtyId, Byte isBudget, Double averageScore, String comments, int id);
}