package lk.ijse.sthub.dto;

public class TeacherDTO {

    private String name;
    private String email;
    private String address;
    private String contact;
    private String scode;
    private String status;

    public TeacherDTO() {
    }

    public TeacherDTO(String name, String email, String address, String contact, String scode, String status) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.scode = scode;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", scode='" + scode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
