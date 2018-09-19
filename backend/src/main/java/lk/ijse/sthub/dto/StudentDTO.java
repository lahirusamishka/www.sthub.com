package lk.ijse.sthub.dto;

public class StudentDTO {



    private String studentname;
    private String email;
    private String address;
    private String contact;

    private String teachername;
    private Long teamid;
    private String status;


    public StudentDTO() {
    }

    public StudentDTO(String studentname, String email, String address, String contact, String teachername, Long teamid, String status) {
        this.studentname = studentname;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.teachername = teachername;
        this.teamid = teamid;
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

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public Long getTeamid() {
        return teamid;
    }

    public void setTeamid(Long teamid) {
        this.teamid = teamid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentname='" + studentname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", teachername='" + teachername + '\'' +
                ", teamid=" + teamid +
                ", status='" + status + '\'' +
                '}';
    }
}
