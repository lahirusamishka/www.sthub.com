package lk.ijse.sthub.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parent {

    @Id
    private String name;
    private String email;
    private String address;
    private String contact;
    private String scode;

    public Parent() {
    }

    public Parent(String name, String email, String address, String contact, String scode) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.scode = scode;
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

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", scode='" + scode + '\'' +
                '}';
    }
}
