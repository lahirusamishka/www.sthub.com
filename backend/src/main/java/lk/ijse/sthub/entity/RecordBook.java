package lk.ijse.sthub.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecordBook {

    @Id
    private String studentName;
    private String date;
    private String teatName;
    private long marks;


    public RecordBook() {
    }

    public RecordBook(String studentName, String date, String teatName, long marks) {
        this.studentName = studentName;
        this.date = date;
        this.teatName = teatName;
        this.marks = marks;
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
        return "RecordBook{" +
                "studentName='" + studentName + '\'' +
                ", date='" + date + '\'' +
                ", teatName='" + teatName + '\'' +
                ", marks=" + marks +
                '}';
    }
}
