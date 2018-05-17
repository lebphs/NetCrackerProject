
package by.netcracker.zhuk.converters;

import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.models.FacultyViewModel;
import by.netcracker.zhuk.models.SpecialtyViewModel;
import by.netcracker.zhuk.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class SpecialityEntityToSpecialityViewModelConverter implements Converter<SpecialtyEntity, SpecialtyViewModel> {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private SpecialtyService specialtyService;

    @Override
    public SpecialtyViewModel convert(SpecialtyEntity specialityEntity) {
        SpecialtyViewModel specialityViewModel = new SpecialtyViewModel();
        specialityViewModel.setName(specialityEntity.getName());
        specialityViewModel.setId(specialityEntity.getId());
        specialityViewModel.setFaculty(conversionService.convert(specialityEntity.getFaculty(), FacultyViewModel.class).getName());
        return specialityViewModel;
    }
}
