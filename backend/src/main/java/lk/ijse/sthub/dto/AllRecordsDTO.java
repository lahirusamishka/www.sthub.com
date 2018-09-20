package lk.ijse.sthub.dto;

public class AllRecordsDTO {

    private Long ARId;
    private String studentName;
    private String date;
    private String teatName;
    private long marks;

    public AllRecordsDTO() {
    }

    public AllRecordsDTO(Long ARId, String studentName, String date, String teatName, long marks) {
        this.ARId = ARId;
        this.studentName = studentName;
        this.date = date;
        this.teatName = teatName;
        this.marks = marks;
    }

    public Long getARId() {
        return ARId;
    }

    public void setARId(Long ARId) {
        this.ARId = ARId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeatName() {
        return teatName;
    }

    public void setTeatName(String teatName) {
        this.teatName = teatName;
    }

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "AllRecordsDTO{" +
                "ARId=" + ARId +
                ", studentName='" + studentName + '\'' +
                ", date='" + date + '\'' +
                ", teatName='" + teatName + '\'' +
                ", marks=" + marks +
                '}';
    }
}
