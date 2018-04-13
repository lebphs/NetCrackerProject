//package by.netcracker.zhuk.entities;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.util.Set;
//
//@Entity
//@Table(name = "practices", schema = "practices", catalog = "")
//public class PracticeEntity {
//    private int id;
//    private String company;
//    private Date startDatePractice;
//    private Date finishDatePractice;
//    //private String companyPracticeStatus;
//    private Integer specialtyId;
//    private Double minAverageScore;
//    private Integer totalQuantity;
//    private Integer headOfPracticeId;
//    private SpecialtyEntity specialty;
//    private UserEntity userByHeadOfPracticeId;
//    private Set<StudentEntity> studentEntities;
//
//    @Id
//    @Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "company", nullable = false, length = 200)
//    public String getCompany() {
//        return company;
//    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }
//
//    @Basic
//    @Column(name = "start_date_practice", nullable = false)
//    public Date getStartDatePractice() {
//        return startDatePractice;
//    }
//
//    public void setStartDatePractice(Date startDatePractice) {
//        this.startDatePractice = startDatePractice;
//    }
//
//    @Basic
//    @Column(name = "finish_date_practice", nullable = false)
//    public Date getFinishDatePractice() {
//        return finishDatePractice;
//    }
//
//    public void setFinishDatePractice(Date finishDatePractice) {
//        this.finishDatePractice = finishDatePractice;
//    }
//
////    @Basic
////    @Column(name = "company_practice_status", nullable = true)
////    public String getCompanyPracticeStatus() {
////        return companyPracticeStatus;
////    }
////
////    public void setCompanyPracticeStatus(String companyPracticeStatus) {
////        this.companyPracticeStatus = companyPracticeStatus;
////    }
//
//    @Basic
//    @Column(name = "specialty_id", nullable = true)
//    public Integer getSpecialtyId() {
//        return specialtyId;
//    }
//
//    public void setSpecialtyId(Integer specialtyId) {
//        this.specialtyId = specialtyId;
//    }
//
//    @Basic
//    @Column(name = "min_average_score", nullable = true)
//    public Double getMinAverageScore() {
//        return minAverageScore;
//    }
//
//    public void setMinAverageScore(Double minAverageScore) {
//        this.minAverageScore = minAverageScore;
//    }
//
//    @Basic
//    @Column(name = "total_quantity", nullable = false)
//    public Integer getTotalQuantity() {
//        return totalQuantity;
//    }
//
//    public void setTotalQuantity(Integer totalQuantity) {
//        this.totalQuantity = totalQuantity;
//    }
//
//    @Basic
//    @Column(name = "user_head_id", nullable = true)
//    public Integer getHeadOfPracticeId() {
//        return headOfPracticeId;
//    }
//
//    public void setHeadOfPracticeId(Integer headOfPracticeId) {
//        this.headOfPracticeId = headOfPracticeId;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        PracticeEntity that = (PracticeEntity) o;
//
//        if (id != that.id) return false;
//        if (totalQuantity != that.totalQuantity) return false;
//        if (headOfPracticeId != that.headOfPracticeId) return false;
//        if (company != null ? !company.equals(that.company) : that.company != null) return false;
//        if (startDatePractice != null ? !startDatePractice.equals(that.startDatePractice) : that.startDatePractice != null)
//            return false;
//        if (finishDatePractice != null ? !finishDatePractice.equals(that.finishDatePractice) : that.finishDatePractice != null)
//            return false;
////        if (companyPracticeStatus != null ? !companyPracticeStatus.equals(that.companyPracticeStatus) : that.companyPracticeStatus != null)
////            return false;
//        if (specialtyId != null ? !specialtyId.equals(that.specialtyId) : that.specialtyId != null) return false;
//        if (minAverageScore != null ? !minAverageScore.equals(that.minAverageScore) : that.minAverageScore != null)
//            return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (company != null ? company.hashCode() : 0);
//        result = 31 * result + (startDatePractice != null ? startDatePractice.hashCode() : 0);
//        result = 31 * result + (finishDatePractice != null ? finishDatePractice.hashCode() : 0);
////        result = 31 * result + (companyPracticeStatus != null ? companyPracticeStatus.hashCode() : 0);
//        result = 31 * result + (specialtyId != null ? specialtyId.hashCode() : 0);
//        result = 31 * result + (minAverageScore != null ? minAverageScore.hashCode() : 0);
//        result = 31 * result + totalQuantity;
//        result = 31 * result + headOfPracticeId;
//        return result;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "specialty_id", referencedColumnName = "id")
//    public SpecialtyEntity getSpecialty() {
//        return specialty;
//    }
//
//    public void setSpecialty(SpecialtyEntity specialtyBySpecialtyId) {
//        this.specialty = specialtyBySpecialtyId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "user_head_id", referencedColumnName = "id")
//    public UserEntity getUserByHeadOfPracticeId() {
//        return userByHeadOfPracticeId;
//    }
//
//    public void setUserByHeadOfPracticeId(UserEntity userByHeadOfPracticeId) {
//        this.userByHeadOfPracticeId = userByHeadOfPracticeId;
//    }
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "practiceEntities")
//    public Set<StudentEntity> getStudentEntities() {
//        return studentEntities;
//    }
//
//    public void setStudentEntities(Set<StudentEntity> studentEntities) {
//        this.studentEntities = studentEntities;
//    }
//}
