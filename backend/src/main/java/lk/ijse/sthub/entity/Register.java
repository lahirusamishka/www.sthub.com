package lk.ijse.sthub.entity;

import javax.persistence.*;

@Entity
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rId")
    private Long rID;

    private String date;

    private Long teamID;


    @ManyToOne
    private Student student;



    public Register() {
    }

    public Register(String date, Long teamID, Student student) {
        this.date = date;
        this.teamID = teamID;
        this.student = student;
    }

    public Long getrID() {
        return rID;
    }

    public void setrID(Long rID) {
        this.rID = rID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Register{" +
                "rID=" + rID +
                ", date='" + date + '\'' +
                ", teamID=" + teamID +
                ", student=" + student +
                '}';
    }
}
