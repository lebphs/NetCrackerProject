package by.netcracker.zhuk.converters;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.models.RequestViewModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import java.util.ArrayList;
import java.util.List;

public class RequestEntityToRequestViewModelConverter implements Converter<RequestEntity, RequestViewModel>{
    @Override
    public RequestViewModel convert(RequestEntity requestEntity)  {
            List<GrantedAuthority> authorities = new ArrayList<>();
            //authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));
            RequestViewModel requestViewModel = new RequestViewModel();

            requestViewModel.setId(requestEntity.getId());
            requestViewModel.setCompanyName(requestEntity.getCompanyName());
            requestViewModel.setDataStart(requestEntity.getStartDate().toString());
            requestViewModel.setDataStart(requestEntity.getFinishDate().toString());


            SpecialtyEntity specialty = requestEntity.getSpecialty();
            requestViewModel.setSpecialty(specialty.getName());
            requestViewModel.setSpecialtyId(specialty.getId());

            FacultyEntity facultyEntity = specialty.getFaculty();
            requestViewModel.setFaculty(facultyEntity.getName());
            requestViewModel.setSpecialtyId(facultyEntity.getId());

//            requestViewModel.setGroup(requestEntity.getGroup());
//            requestViewModel.setIsBudget(requestEntity.getIsBudget());
            requestViewModel.setMinAverageScore(requestEntity.getMinAverageScore());
            requestViewModel.setTotalQuantity(requestEntity.getTotalQuantity());

            return requestViewModel;
    }
}