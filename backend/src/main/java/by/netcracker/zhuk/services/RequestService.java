package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.RequestEntity;

import java.util.List;

public interface RequestService {

    void addRequest(RequestEntity requestEntity);

    List<RequestEntity> findAllRequests();

    void delete(String studentId);

    RequestEntity getRequestById(String requestId);

    RequestEntity getRequestByName(String name);

    List<RequestEntity> findRequestsByAvScoreAndSpecialty(double score, int idSpecialty);
}
