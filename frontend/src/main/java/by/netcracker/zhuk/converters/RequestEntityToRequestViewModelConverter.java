package by.netcracker.zhuk.converters;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.models.RequestViewModel;
import org.springframework.core.convert.converter.Converter;

public class RequestEntityToRequestViewModelConverter implements Converter<RequestEntity, RequestViewModel> {
    @Override
    public RequestViewModel convert(RequestEntity requestEntity) {
        //List<GrantedAuthority> authorities = new ArrayList<>();
        //authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));
        RequestViewModel requestViewModel = new RequestViewModel();

        requestViewModel.setId(requestEntity.getId());
        requestViewModel.setCompanyName(requestEntity.getCompanyName());
        requestViewModel.setStartDate(requestEntity.getStartDate().toString());
        requestViewModel.setFinishDate(requestEntity.getFinishDate().toString());


        SpecialtyEntity specialty = requestEntity.getSpecialty();
        requestViewModel.setSpecialty(specialty.getName());
        requestViewModel.setSpecialtyId(specialty.getId());

        FacultyEntity facultyEntity = specialty.getFaculty();
        requestViewModel.setFaculty(facultyEntity.getName());
        requestViewModel.setFacultyId(facultyEntity.getId());

//            requestViewModel.setGroup(requestEntity.getGroup());
//            requestViewModel.setIsBudget(requestEntity.getIsBudget());
        requestViewModel.setMinAverageScore(requestEntity.getMinAverageScore());
        requestViewModel.setTotalQuantity(requestEntity.getTotalQuantity());

        return requestViewModel;
    }
}