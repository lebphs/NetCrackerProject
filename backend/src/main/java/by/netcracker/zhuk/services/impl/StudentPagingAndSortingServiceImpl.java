package by.netcracker.zhuk.services.impl;

import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.repository.StudentPagingAndSortingRepository;
import by.netcracker.zhuk.services.SpecialtyService;
import by.netcracker.zhuk.services.StudentPagingAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentPagingAndSortingServiceImpl implements StudentPagingAndSortingService {
    @Autowired
    StudentPagingAndSortingRepository studentPagingAndSortingRepository;

    @Autowired
    SpecialtyService specialtyService;
//rest
    @Override
    public List<StudentEntity> getPagingAndSortedStudent(String search, String sort, String order, Integer offset, Integer limit) {
        int pageNumber = offset / limit;
        if(sort.equals("specialty")){
            sort = "specialityId.name";
        }
        if(sort.equals("faculty")){
            sort = "specialityId.faculty.name";
        }
        Sort sort1 = new Sort(Sort.Direction.fromString(order), sort);
        Pageable pageable = new PageRequest(pageNumber, limit, sort1);
        if (!search.equals("")) {
            return studentPagingAndSortingRepository.findStudentEntitiesBySurnameContaining(search);
        }
        return studentPagingAndSortingRepository.findAll(pageable).getContent();
    }
}
