package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.RequestEntity;

import java.util.List;

public interface RequestService {
//    List<PracticeEntity> getPracticeByUserCreatorId(String userCreatorId);
    void addRequest(RequestEntity requestEntity);
    List<RequestEntity> findAllRequests();
    //void delete(String studentId);
    //RequestEntity getRequestById(String practiceId);
}
