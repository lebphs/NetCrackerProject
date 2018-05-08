package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.StudentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestPagingAndSortingRepository extends PagingAndSortingRepository<RequestEntity, Integer> {
    List<RequestEntity> findRequestEntitiesByCompanyName(String name);
}
