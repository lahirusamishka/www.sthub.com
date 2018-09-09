package lk.ijse.sthub.dto;

public class StudentDTO {

    private Long stId;

    private String name;
    private String address;
    private String contact;
    private String email;

    public StudentDTO() {
    }

    public StudentDTO(Long stId, String name, String address, String contact, String email) {
        this.stId = stId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public Long getStId() {
        return stId;
    }

    public void setStId(Long stId) {
        this.stId = stId;
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
        return "StudentDTO{" +
                "stId=" + stId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
