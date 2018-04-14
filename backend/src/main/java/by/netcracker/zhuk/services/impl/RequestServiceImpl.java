package by.netcracker.zhuk.services.impl;

import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.repository.RequestRepository;
import by.netcracker.zhuk.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Override
    public void addRequest(RequestEntity requestEntity) {
        requestRepository.save(requestEntity);
    }

//    @Override
//    public List<PracticeEntity> getAllPractice() {
//        return null;
//    }
//
//    @Override
//    public void delete(String studentId) {
//
//    }
//
//    @Override
//    public PracticeEntity getPracticeById(String practiceId) {
//        return null;
//    }
}