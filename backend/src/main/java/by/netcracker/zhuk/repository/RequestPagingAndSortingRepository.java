package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.RequestEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface RequestPagingAndSortingRepository extends PagingAndSortingRepository<RequestEntity, Integer> {
    List<RequestEntity> findRequestEntitiesByCompanyName(String name);

    List<RequestEntity> findRequestEntitiesByCompanyNameContaining(String name);
}
