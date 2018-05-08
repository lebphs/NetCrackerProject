package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.StudentEntity;

import java.util.List;

public interface StudentPagingAndSortingService {
    List<StudentEntity> getPagingAndSortedStudent(String search, String sort, String order, Integer offset, Integer limit);
}
