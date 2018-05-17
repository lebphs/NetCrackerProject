
package by.netcracker.zhuk.converters;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.models.FacultyViewModel;
import org.springframework.core.convert.converter.Converter;


public class FacultyEntityToFacultyViewModelConverter implements Converter<FacultyEntity, FacultyViewModel> {

    @Override
    public FacultyViewModel convert(FacultyEntity facultyEntity) {

        FacultyViewModel facultyViewModel = new FacultyViewModel();
        facultyViewModel.setName(facultyEntity.getName());
        facultyViewModel.setId(facultyEntity.getId());
        return facultyViewModel;
    }
}
