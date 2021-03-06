package by.netcracker.zhuk.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "students", schema = "practices", catalog = "")
public class StudentEntity {
    private int id;
    private String surname;
    private String name;
    private Integer group;
    private SpecialtyEntity specialityId;
    private String isBudget;
    private double averageScore;
    private Set<RequestEntity> requestEntities;


    private String studentStatus;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "group_number")
    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "is_budget")
    public String getIsBudget() {
        return isBudget;
    }

    public void setIsBudget(String isBudget) {
        this.isBudget = isBudget;
    }

    @Basic
    @Column(name = "average_score")
    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Basic
    @Column(name = "student_status")
    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    @ManyToOne
    @JoinColumn(name = "specialty_id", referencedColumnName = "id")
    public SpecialtyEntity getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(SpecialtyEntity specialityId) {
        this.specialityId = specialityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id &&
                Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, group);
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "request_has_students",
            joinColumns = {@JoinColumn(name = "students_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "requests_id", referencedColumnName = "id")})
    public Set<RequestEntity> getRequestEntities() {
        return requestEntities;
    }

    public void setRequestEntities(Set<RequestEntity> requestEntities) {
        this.requestEntities = requestEntities;
    }
}