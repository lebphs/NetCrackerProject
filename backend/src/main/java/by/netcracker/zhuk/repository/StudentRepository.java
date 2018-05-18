package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
    StudentEntity findBySurname(String surname);

    @Query(value = "SELECT * FROM students WHERE average_score > :score and specialty_id = :idSpecialty", nativeQuery = true)
    List<StudentEntity> findStudentsByAvScoreAndSpecialty(@Param("score") Double score, @Param("idSpecialty") Integer idSpecialty);

}