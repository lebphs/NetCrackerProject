package by.netcracker.zhuk.converters;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.models.RequestViewModel;
import org.springframework.core.convert.converter.Converter;
import by.netcracker.zhuk.utils.Util;

public class RequestEntityToRequestViewModelConverter implements Converter<RequestEntity, RequestViewModel> {

    @Override
    public RequestViewModel convert(RequestEntity requestEntity) {
        RequestViewModel requestViewModel = new RequestViewModel();

        requestViewModel.setId(requestEntity.getId());
        requestViewModel.setCompanyName(requestEntity.getCompanyName());
        requestViewModel.setStartDate(requestEntity.getStartDate().toString());
        requestViewModel.setFinishDate(requestEntity.getFinishDate().toString());
        requestViewModel.setPracticePeriod(requestViewModel.getStartDate() + " - " + requestViewModel.getFinishDate());


        SpecialtyEntity specialty = requestEntity.getSpecialty();
        requestViewModel.setSpecialty(specialty.getName());
        requestViewModel.setSpecialtyId(specialty.getId());

        FacultyEntity facultyEntity = specialty.getFaculty();
        requestViewModel.setFaculty(facultyEntity.getName());
        requestViewModel.setFacultyId(facultyEntity.getId());


        requestViewModel.setMinAverageScore(requestEntity.getMinAverageScore());
        requestViewModel.setTotalQuantity(requestEntity.getTotalQuantity());
        requestViewModel.setAvailableQuantity(requestEntity.getTotalQuantity() - requestEntity.getStudentEntities().size());
        requestViewModel.setStudentStatus(Util.compareDate(requestViewModel.getStartDate(), requestViewModel.getFinishDate()));
        requestViewModel.setPracticeStatus(Util.checkStatusPractice(requestViewModel.getFinishDate(),requestViewModel.getAvailableQuantity()));

        return requestViewModel;
    }




}