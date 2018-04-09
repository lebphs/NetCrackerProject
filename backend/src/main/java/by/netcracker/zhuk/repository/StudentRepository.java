package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
//    @Query(value = "SELECT MAX(id) FROM students", nativeQuery = true)
//    int getIdLastCreatedStudent();
}