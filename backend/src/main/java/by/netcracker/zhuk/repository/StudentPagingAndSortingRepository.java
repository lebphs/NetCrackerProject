package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.StudentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentPagingAndSortingRepository extends PagingAndSortingRepository<StudentEntity, Integer> {
    List<StudentEntity> findStudentEntitiesBySurname(String name);
    List<StudentEntity> findStudentEntitiesBySurnameContaining(String name);
}
