package by.netcracker.zhuk.converters;


import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.models.StudentViewModel;
import org.springframework.core.convert.converter.Converter;


public class StudentEntityToStudentViewModelConverter implements Converter<StudentEntity, StudentViewModel> {

    @Override
    public StudentViewModel convert(StudentEntity studentEntity) {

        StudentViewModel studentViewModel = new StudentViewModel();

        studentViewModel.setId(studentEntity.getId());
        studentViewModel.setSurname(studentEntity.getSurname());
        studentViewModel.setName(studentEntity.getName());


        SpecialtyEntity specialty = studentEntity.getSpecialityId();
        studentViewModel.setSpecialty(specialty.getName());
        studentViewModel.setSpecialtyId(specialty.getId());

        FacultyEntity facultyEntity = specialty.getFaculty();
        studentViewModel.setFaculty(facultyEntity.getName());
        studentViewModel.setSpecialtyId(facultyEntity.getId());

        studentViewModel.setGroup(studentEntity.getGroup());
        studentViewModel.setIsBudget(studentEntity.getIsBudget());
        studentViewModel.setAverageScore(studentEntity.getAverageScore());
        studentViewModel.setStudentStatus(studentEntity.getStudentStatus());

        return studentViewModel;
    }

}