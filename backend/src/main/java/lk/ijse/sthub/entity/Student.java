package lk.ijse.sthub.entity;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    private String studentname;

    private String email;
    private String address;
    private String contact;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;
    private String status;

    public Student() {
    }

    public Student(String studentname, String email, String address, String contact, Teacher teacher, Team team, String status) {
        this.studentname = studentname;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.teacher = teacher;
        this.team = team;
        this.status = status;
    }



    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentname='" + studentname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", teacher=" + teacher +
                ", team=" + team +
                ", status='" + status + '\'' +
                '}';
    }

}
