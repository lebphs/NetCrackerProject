package by.netcracker.zhuk.repository;

import by.netcracker.zhuk.entities.RequestEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<RequestEntity, Integer> {
//    List<PracticeEntity> findByUserHeadId(int headOfPracticeId);
}