package by.netcracker.zhuk.converters;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.models.RequestViewModel;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class RequestEntityToRequestViewModelConverter implements Converter<RequestEntity, RequestViewModel> {
    public static final String NOT_ALLOCATED = "Not allocated";
    public static final String WAITING_FOR_PRACTICE = "Waiting for practice";
    public static final String ON_PRACTICE = "On practice";
    public static final String AFTER_PRACTICE = "Practice ended";

    @Override
    public RequestViewModel convert(RequestEntity requestEntity) {
        //List<GrantedAuthority> authorities = new ArrayList<>();
        //authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));
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

//            requestViewModel.setGroup(requestEntity.getGroup());
//            requestViewModel.setIsBudget(requestEntity.getIsBudget());
        requestViewModel.setMinAverageScore(requestEntity.getMinAverageScore());
        requestViewModel.setTotalQuantity(requestEntity.getTotalQuantity());
        requestViewModel.setAvailableQuantity(requestEntity.getTotalQuantity() - requestEntity.getStudentEntities().size());
        requestViewModel.setStudentStatus(compareDate(requestViewModel.getStartDate(), requestViewModel.getFinishDate()));
        requestViewModel.setPracticeStatus(compareQuantity(requestViewModel.getAvailableQuantity()));

        return requestViewModel;
    }



    public String compareQuantity(int quantity){
        if(quantity > 0){
            return "Available";
        }
        else{
            return "Not available";
        }
    }

    public String compareDate(String startDate, String finishDate) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getDefault());
        Date current = new Date();
        Date start = null;
        Date finish = null;
        try {
            start = sdf.parse(startDate);
            finish = sdf.parse(finishDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (current.before(start) && current.before(finish)){
            return WAITING_FOR_PRACTICE;
        } else if (current.after(start) && current.before(finish)){
            return ON_PRACTICE;
        } else if (current.after(start) && current.after(finish)){
            return AFTER_PRACTICE;
        }

        return NOT_ALLOCATED;
    }
}