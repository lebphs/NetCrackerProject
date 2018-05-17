package by.netcracker.zhuk.validator.Impl;

import by.netcracker.zhuk.entities.RequestEntity;

import java.sql.Date;

public class RequestValidatorImpl {

    private boolean nullCheck(RequestEntity requestEntity) {

        return requestEntity.getCompanyName() != null && requestEntity.getTotalQuantity() != null
                && requestEntity.getMinAverageScore() != null && requestEntity.getStartDate() != null
                && requestEntity.getFinishDate() != null;
    }

    private boolean checkData(RequestEntity requestEntity) {
//        System.out.println(requestEntity.getCompanyName().matches("[a-zA-Z]+"));
//        System.out.println(String.valueOf(requestEntity.getMinAverageScore()).matches("([0-9][.][0-9]{1,2})|10"));
//        System.out.println(String.valueOf(requestEntity.getTotalQuantity()).matches("[0-9]+"));
//        System.out.println ("   "+String.valueOf(requestEntity.getStartDate()).matches("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}"));
//        System.out.println(String.valueOf(requestEntity.getStartDate()).matches("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}"));

        return String.valueOf(requestEntity.getMinAverageScore()).matches("([0-9][.][0-9]{1,2})|10")
                && String.valueOf(requestEntity.getTotalQuantity()).matches("[0-9]+") &&
                String.valueOf(requestEntity.getStartDate()).matches("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}") &&
                String.valueOf(requestEntity.getStartDate()).matches("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}");
    }

    private boolean compareDate(Date dataFrom, Date dataTo){
        return !dataFrom.after(dataTo);
    }

    private boolean validationQuantityStudent(RequestEntity requestEntity){
        System.out.println(requestEntity.getTotalQuantity());
        System.out.println(requestEntity.getStudentEntities().size());
        System.out.println("eheh"+(requestEntity.getTotalQuantity()- requestEntity.getStudentEntities().size() >= 0));
        return requestEntity.getTotalQuantity()- requestEntity.getStudentEntities().size() >= 0;
    }

    public boolean requestValidation(RequestEntity requestEntity) {
//        System.out.println("asdf " +nullCheck(requestEntity));
//        System.out.println("data "+checkData(requestEntity));
//        System.out.println("date "+compareDate(requestEntity.getStartDate(), requestEntity.getFinishDate()));
        return checkData(requestEntity) && nullCheck(requestEntity) && compareDate(requestEntity.getStartDate(), requestEntity.getFinishDate())
                && validationQuantityStudent(requestEntity);
    }
}
