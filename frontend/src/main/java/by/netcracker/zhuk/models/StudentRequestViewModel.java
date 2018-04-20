package by.netcracker.zhuk.models;

import java.util.List;

public class StudentRequestViewModel {
    private List<String> idStudents;
    private String idRequest;

    public List<String> getIdStudents() {
        return idStudents;
    }

    public void setIdStudents(List<String> idStudents) {
        this.idStudents = idStudents;
    }

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
    }
}
