package by.netcracker.zhuk.converters;

import by.netcracker.zhuk.entities.FacultyEntity;
import by.netcracker.zhuk.models.FacultyViewModel;
import org.springframework.core.convert.converter.Converter;

public class FacultyViewModelToFacultyEntityConverter implements Converter<FacultyViewModel, FacultyEntity> {

    @Override
    public FacultyEntity convert(FacultyViewModel facultyViewModel) {

        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setName(facultyViewModel.getName());
        return facultyEntity;
    }
}
