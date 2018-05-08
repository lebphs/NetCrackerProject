package by.netcracker.zhuk.services;

import by.netcracker.zhuk.entities.RequestEntity;


import java.util.List;

public interface RequestPagingAndSortingService {
    List<RequestEntity> getPagingAndSortedRequest(String search, String sort, String order, Integer offset, Integer limit);
}
