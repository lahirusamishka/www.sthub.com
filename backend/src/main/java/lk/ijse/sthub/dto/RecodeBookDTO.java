package lk.ijse.sthub.dto;

public class RecodeBookDTO {

    private Long recodeBookId;
    private String subject;
    private String date;
    private long marks;


    public RecodeBookDTO() {
    }

    public RecodeBookDTO(Long recodeBookId, String subject, String date, long marks) {
        this.recodeBookId = recodeBookId;
        this.subject = subject;
        this.date = date;
        this.marks = marks;
    }

    public Long getRecodeBookId() {
        return recodeBookId;
    }

    public void setRecodeBookId(Long recodeBookId) {
        this.recodeBookId = recodeBookId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "RecodeBookDTO{" +
                "recodeBookId=" + recodeBookId +
                ", subject='" + subject + '\'' +
                ", date='" + date + '\'' +
                ", marks=" + marks +
                '}';
    }
}
