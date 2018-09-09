package lk.ijse.sthub.dto;

public class TeamDTO {

    private Long id;
    private String teamName;
    private String description;
    private String visible;
    private TeacherDTO teacherDTO;


    public TeamDTO() {
    }

    public TeamDTO(Long id, String teamName, String description, String visible, TeacherDTO teacherDTO) {
        this.id = id;
        this.teamName = teamName;
        this.description = description;
        this.visible = visible;
        this.teacherDTO = teacherDTO;
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

    public TeacherDTO getTeacherDTO() {
        return teacherDTO;
    }

    public void setTeacherDTO(TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", description='" + description + '\'' +
                ", visible='" + visible + '\'' +
                ", teacherDTO=" + teacherDTO +
                '}';
    }
}
