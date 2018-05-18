
package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.FacultyEntity;
import org.springframework.data.repository.CrudRepository;


public interface FacultyRepository extends CrudRepository<FacultyEntity, Integer> {
    FacultyEntity findById(Integer id);

    FacultyEntity findByName(String name);
}