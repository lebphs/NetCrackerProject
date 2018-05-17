package by.netcracker.zhuk.converters;


import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.models.StudentViewModel;
import by.netcracker.zhuk.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class StudentViewModelToStudentEntityConverter implements Converter<StudentViewModel, StudentEntity> {

    @Autowired
    SpecialtyService specialtyService;

    @Override
    public StudentEntity convert(StudentViewModel student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setSurname(student.getSurname());
        studentEntity.setName(student.getName());
        studentEntity.setSpecialityId(specialtyService.findById(student.getSpecialtyId()));
        studentEntity.setGroup(student.getGroup());
        studentEntity.setIsBudget(student.getIsBudget());
        studentEntity.setAverageScore(student.getAverageScore());
        return studentEntity;
    }
}