package lk.ijse.sthub.dto;

public class TeamDTO2 {

    private Long teamId;
    private String teamName;
    private String description;
    private String visible;
    private String teacherEmail;

    public TeamDTO2() {
    }

    public TeamDTO2(Long teamId, String teamName, String description, String visible, String teacherEmail) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.description = description;
        this.visible = visible;
        this.teacherEmail = teacherEmail;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
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

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    @Override
    public String toString() {
        return "TeamDTO2{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", description='" + description + '\'' +
                ", visible='" + visible + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                '}';
    }
}
