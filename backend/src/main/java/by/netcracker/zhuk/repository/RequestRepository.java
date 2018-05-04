package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.RequestEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<RequestEntity, Integer> {
    RequestEntity findById(Integer id);
    RequestEntity findByCompanyName(String name);
}