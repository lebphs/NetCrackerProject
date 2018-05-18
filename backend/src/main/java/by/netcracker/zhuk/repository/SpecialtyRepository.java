package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.SpecialtyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SpecialtyRepository extends CrudRepository<SpecialtyEntity, Integer> {
    List<SpecialtyEntity> findSpecialtyByFacultyId(int facultyId);

    SpecialtyEntity findById(Integer id);

    SpecialtyEntity findByName(String name);
}