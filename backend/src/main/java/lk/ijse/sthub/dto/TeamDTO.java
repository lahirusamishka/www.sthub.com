package lk.ijse.sthub.dto;

public class TeamDTO {

    private Long teamid;
    private String subject;
    private String discription;
    private boolean visibles;
    private String teacherUserName;


    public TeamDTO() {

    }

    public TeamDTO(Long teamid, String subject, String discription, boolean visibles, String teacherUserName) {
        this.teamid = teamid;
        this.subject = subject;
        this.discription = discription;
        this.visibles = visibles;
        this.teacherUserName = teacherUserName;
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

    public String getTeacherUserName() {
        return teacherUserName;
    }

    public void setTeacherUserName(String teacherUserName) {
        this.teacherUserName = teacherUserName;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "teamid=" + teamid +
                ", subject='" + subject + '\'' +
                ", discription='" + discription + '\'' +
                ", visibles=" + visibles +
                ", teacherUserName='" + teacherUserName + '\'' +
                '}';
    }
}
