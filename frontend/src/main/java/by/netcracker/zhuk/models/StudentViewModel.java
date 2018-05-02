package by.netcracker.zhuk.models;

import by.netcracker.zhuk.entities.RequestEntity;
import by.netcracker.zhuk.entities.StudentEntity;

import java.util.List;

public class StudentViewModel {
    private int id;
    private List<String> studentsList;
    private List<String> requestsList;
    private String surname;
    private String name;
    private String faculty;
    private Integer facultyId;
    private String specialty;
    private Integer specialtyId;
    private int group;
    private String isBudget;
    private double averageScore;
    private String studentStatus;

    public StudentViewModel(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getIsBudget() {
        return isBudget;
    }

    public void setIsBudget(String isBudget) {
        this.isBudget = isBudget;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public List<String> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<String> studentsList) {
        this.studentsList = studentsList;
    }

    public List<String> getRequestsList() {
        return requestsList;
    }

    public void setRequestsList(List<String> requestsList) {
        this.requestsList = requestsList;
    }
}
