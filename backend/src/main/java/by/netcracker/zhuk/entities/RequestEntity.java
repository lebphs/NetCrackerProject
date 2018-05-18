package by.netcracker.zhuk.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "request", schema = "practices", catalog = "")
public class RequestEntity {
    private int id;
    private String companyName;
    private Date startDate;
    private Date finishDate;
    ;
    private Double minAverageScore;
    private Integer totalQuantity;
    private SpecialtyEntity specialty;
    private Set<StudentEntity> studentEntities;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "company", nullable = false, length = 200)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "start_date_practice", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "finish_date_practice", nullable = false)
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Basic
    @Column(name = "min_average_score", nullable = true)
    public Double getMinAverageScore() {
        return minAverageScore;
    }

    public void setMinAverageScore(Double minAverageScore) {
        this.minAverageScore = minAverageScore;
    }

    @Basic
    @Column(name = "total_quantity", nullable = false)
    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestEntity that = (RequestEntity) o;

        if (getId() != that.getId()) return false;
        if (getCompanyName() != null ? !getCompanyName().equals(that.getCompanyName()) : that.getCompanyName() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(that.getStartDate()) : that.getStartDate() != null)
            return false;
        if (getFinishDate() != null ? !getFinishDate().equals(that.getFinishDate()) : that.getFinishDate() != null)
            return false;
        if (getMinAverageScore() != null ? !getMinAverageScore().equals(that.getMinAverageScore()) : that.getMinAverageScore() != null)
            return false;
        if (getTotalQuantity() != null ? !getTotalQuantity().equals(that.getTotalQuantity()) : that.getTotalQuantity() != null)
            return false;
        if (specialty != null ? !specialty.equals(that.specialty) : that.specialty != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getFinishDate() != null ? getFinishDate().hashCode() : 0);
        result = 31 * result + (getMinAverageScore() != null ? getMinAverageScore().hashCode() : 0);
        result = 31 * result + (getTotalQuantity() != null ? getTotalQuantity().hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        return result;
    }


    @ManyToOne
    @JoinColumn(name = "specialty_id", referencedColumnName = "id")
    public SpecialtyEntity getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyEntity specialtyBySpecialtyId) {
        this.specialty = specialtyBySpecialtyId;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "requestEntities")
    public Set<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(Set<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }
}
