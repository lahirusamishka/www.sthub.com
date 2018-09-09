package lk.ijse.sthub.entity;

import javax.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tId")
    private Long id;

    private String teamName;
    private String description;
    private String visible;

    @ManyToOne
    private Teacher teacher;


    public Team() {
    }

    public Team(String teamName, String description, String visible, Teacher teacher) {
        this.teamName = teamName;
        this.description = description;
        this.visible = visible;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
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
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", description='" + description + '\'' +
                ", visible='" + visible + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
