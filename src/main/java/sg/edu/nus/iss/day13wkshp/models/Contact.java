package sg.edu.nus.iss.day13wkshp.models;

import java.util.UUID;

public class Contact {
    private String name;
    private String email;
    private String phone;
    private final String id;

    public Contact(String name, String email, String phone) {
        // this.name = name;
        // this.email = email;
        // this.phone = phone;
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public Contact(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact [email=" + email + ", id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }

}
