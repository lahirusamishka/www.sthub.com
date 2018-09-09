package lk.ijse.sthub.dto;

public class RegisterDTO {

    private Long rID;
    private String date;
    private StudentDTO studentDTO;
    private Long teamId;

    public RegisterDTO() {

    }

    public RegisterDTO(Long rID, String date, StudentDTO studentDTO, Long teamId) {
        this.rID = rID;
        this.date = date;
        this.studentDTO = studentDTO;
        this.teamId = teamId;
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

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "rID=" + rID +
                ", date='" + date + '\'' +
                ", studentDTO=" + studentDTO +
                ", teamId=" + teamId +
                '}';
    }
}
