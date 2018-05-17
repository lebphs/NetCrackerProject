package by.netcracker.zhuk.converters;

import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.models.RequestViewModel;
import by.netcracker.zhuk.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.sql.Date;
import java.util.HashSet;

public class RequestViewModelToRequestEntityConverter implements Converter<RequestViewModel, RequestEntity> {

    @Autowired
    SpecialtyRepository specialtyService;

    @Override
    public RequestEntity convert(RequestViewModel request) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setCompanyName(request.getCompanyName());
        requestEntity.setStartDate(Date.valueOf(request.getStartDate()));
        requestEntity.setFinishDate(Date.valueOf(request.getFinishDate()));
        requestEntity.setSpecialty(specialtyService.findById(request.getSpecialtyId()));
        requestEntity.setTotalQuantity(request.getTotalQuantity());
        requestEntity.setMinAverageScore(request.getMinAverageScore());
        requestEntity.setStudentEntities(new HashSet<>());
        return requestEntity;
    }
}