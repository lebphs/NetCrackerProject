package by.netcracker.zhuk.converters;


import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.models.StudentViewModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;


public class StudentEntityToStudentViewModelConverter implements Converter<StudentEntity, StudentViewModel> {


    @Override
    public StudentViewModel convert(StudentEntity studentEntity)  {
        //List<GrantedAuthority> authorities = new ArrayList<>();
        //authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));
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

//        if (specialty != null) {
//            studentViewModel.setSpecialty(String.valueOf(student.getId()));
//            SpecialityEntity speciality = student.getSpeciality();
//            if (speciality != null) {
//                studentViewModel.setSpecialityId(String.valueOf(speciality.getId()));
//                studentViewModel.setSpecialityName(speciality.getName());
//                FacultyEntity faculty = speciality.getFaculty();
//                if (faculty != null) {
//                    studentViewModel.setFacultyId(String.valueOf(faculty.getId()));
//                    studentViewModel.setFacultyName(faculty.getName());
//                }
//            }
//
//        }
        return studentViewModel;
    }
}