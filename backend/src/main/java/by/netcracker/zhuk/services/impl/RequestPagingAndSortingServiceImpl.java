package by.netcracker.zhuk.services.impl;

import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.repository.RequestPagingAndSortingRepository;
import by.netcracker.zhuk.services.RequestPagingAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RequestPagingAndSortingServiceImpl implements RequestPagingAndSortingService {

    @Autowired
    RequestPagingAndSortingRepository requestPagingAndSortingRepository;
    //rest

    @Override
    public List<RequestEntity> getPagingAndSortedRequest(String search, String sort, String order, Integer offset, Integer limit) {
        int pageNumber = offset / limit;
        if(sort.equals("specialty")){
            sort = "specialty.name";
        }
        if(sort.equals("faculty")){
            sort = "specialty.faculty.name";
        }
        Sort sort1 = new Sort(Sort.Direction.fromString(order), sort);
        Pageable pageable = new PageRequest(pageNumber, limit, sort1);
        if (!search.equals("")) {
            return requestPagingAndSortingRepository.findRequestEntitiesByCompanyName(search);
        }
        return requestPagingAndSortingRepository.findAll(pageable).getContent();
    }
}
