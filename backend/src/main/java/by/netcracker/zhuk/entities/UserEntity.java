package by.netcracker.zhuk.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "practices", catalog = "")
public class UserEntity {
    private int id;
    private UserRoleEntity role;
    private String username;
    private String password;
    private StudentEntity student;
    private RequestEntity request;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "login")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(role, that.role) &&

                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, role, username, password);
    }

    @OneToOne
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    public RequestEntity getRequest() {
        return request;
    }

    public void setRequest(RequestEntity request) {
        this.request = request;
    }

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    public UserRoleEntity getRole() {
        return role;
    }

    public void setRole(UserRoleEntity role) {
        this.role = role;
    }

}
