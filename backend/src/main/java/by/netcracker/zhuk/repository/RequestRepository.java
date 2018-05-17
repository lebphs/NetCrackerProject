package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends CrudRepository<RequestEntity, Integer> {
    RequestEntity findById(Integer id);
    RequestEntity findByCompanyName(String name);

    @Query(value = "SELECT * FROM request WHERE min_average_score < :score and specialty_id = :idSpecialty", nativeQuery = true)
    List<RequestEntity> findRequestsByAvScoreAndSpecialty(@Param("score") double score, @Param("idSpecialty") int idSpecialty);
}