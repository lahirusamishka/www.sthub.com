package lk.ijse.sthub.dto;

public class TeamDTO2 {

    private Long teamId;
    private String teamName;
    private String description;
    private String visible;
    private Long teacherId;

    public TeamDTO2() {
    }

    public TeamDTO2(Long teamId, String teamName, String description, String visible, Long teacherId) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.description = description;
        this.visible = visible;
        this.teacherId = teacherId;
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "TeamDTO2{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", description='" + description + '\'' +
                ", visible='" + visible + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}
