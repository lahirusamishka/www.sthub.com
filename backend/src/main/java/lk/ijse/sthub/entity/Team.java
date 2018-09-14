package lk.ijse.sthub.entity;

import javax.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tId")
    private Long teamid;
    private String subject;
    private String discription;
    private boolean visibles;
    @ManyToOne
    private Teacher teacher;


    public Team() {
    }

    public Team(String subject, String discription, boolean visibles, Teacher teacher) {
        this.subject = subject;
        this.discription = discription;
        this.visibles = visibles;
        this.teacher = teacher;
    }

    public Long getTeamid() {
        return teamid;
    }

    public void setTeamid(Long teamid) {
        this.teamid = teamid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isVisibles() {
        return visibles;
    }

    public void setVisibles(boolean visibles) {
        this.visibles = visibles;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamid=" + teamid +
                ", subject='" + subject + '\'' +
                ", discription='" + discription + '\'' +
                ", visibles=" + visibles +
                ", teacher=" + teacher +
                '}';
    }
}
