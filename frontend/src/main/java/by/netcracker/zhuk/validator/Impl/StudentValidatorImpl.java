package by.netcracker.zhuk.validator.Impl;

import by.netcracker.zhuk.entities.StudentEntity;
import by.netcracker.zhuk.validator.StudentValidator;

public class StudentValidatorImpl implements StudentValidator {

    private boolean nullCheck(StudentEntity studentEntity) {

        return studentEntity.getSurname() != null && studentEntity.getName() != null
                && studentEntity.getGroup() != null && studentEntity.getAverageScore() != 0;
    }

    private boolean checkData(StudentEntity studentEntity) {

        return studentEntity.getSurname().matches("[a-zA-Z]+") && studentEntity.getName().matches("[a-zA-Z]+")
                && String.valueOf(studentEntity.getAverageScore()).matches("([0-9][.][0-9]{1,2})|10")
                && String.valueOf(studentEntity.getGroup()).matches("[0-9]+");
    }

    public boolean studentValidation(StudentEntity studentEntity) {
        return checkData(studentEntity) && nullCheck(studentEntity);
    }
}
