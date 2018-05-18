
package by.netcracker.zhuk.converters;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.models.SpecialtyViewModel;
import by.netcracker.zhuk.services.FacultyService;
import by.netcracker.zhuk.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class SpecialityViewModelToSpecialityEntityConverter implements Converter<SpecialtyViewModel, SpecialtyEntity> {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private SpecialtyService specialtyService;
    @Autowired
    private FacultyService facultyService;

    @Override
    public SpecialtyEntity convert(SpecialtyViewModel specialityViewModel) {
        SpecialtyEntity specialityEntity = new SpecialtyEntity();
        specialityEntity.setName(specialityViewModel.getName());
        specialityEntity.setFaculty(conversionService.convert(facultyService.findById(specialityViewModel.getFacultyId()), FacultyEntity.class));
        return specialityEntity;
    }
}
