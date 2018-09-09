package lk.ijse.sthub.dto;

public class TeacherDTO {
    private Long tid;

    private String name;
    private String address;
    private String contact;
    private String email;

    public TeacherDTO(){
    }

    public TeacherDTO(Long tid, String name, String address, String contact, String email) {
        this.tid = tid;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
