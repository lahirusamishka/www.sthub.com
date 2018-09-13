package lk.ijse.sthub.dto;

public class TeacherDTO {

    private String name;
    private String email;
    private String address;
    private String contact;
    private String scode;

    public TeacherDTO() {
    }

    public TeacherDTO(String name, String address, String contact, String email, String scode) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.scode = scode;
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

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", scode='" + scode + '\'' +
                '}';
    }
}
