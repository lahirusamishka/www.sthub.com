package lk.ijse.sthub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecodeBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recodeBookId;
    private String subject;
    private String date;
    private long marks;

    public RecodeBook() {
    }

    public RecodeBook(String subject, String date, long marks) {
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
        return "RecodeBook{" +
                "recodeBookId=" + recodeBookId +
                ", subject='" + subject + '\'' +
                ", date='" + date + '\'' +
                ", marks=" + marks +
                '}';
    }
}
