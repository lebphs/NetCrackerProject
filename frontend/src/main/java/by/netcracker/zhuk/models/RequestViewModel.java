package by.netcracker.zhuk.models;

public class RequestViewModel {
    private int id;
    private String companyName;
    private String dataStart;
    private String dataFinish;
    private String specialty;
    private Integer specialtyId;
    private String faculty;
    private Integer facultyId;
    private double minAverageScore;
    private int totalQuantity;
    private String user;
    private Integer userId;


    public RequestViewModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDataStart() {
        return dataStart;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public String getDataFinish() {
        return dataFinish;
    }

    public void setDataFinish(String dataFinish) {
        this.dataFinish = dataFinish;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public double getMinAverageScore() {
        return minAverageScore;
    }

    public void setMinAverageScore(double minAverageScore) {
        this.minAverageScore = minAverageScore;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
