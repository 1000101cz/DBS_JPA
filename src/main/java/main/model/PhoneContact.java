package main.model;

import jakarta.persistence.*;

@Entity(name="PhoneContact")
@Table(name="phonecontact")
public class PhoneContact {
    @Id
    @ManyToOne
    @JoinColumn(name="employee")
    private Employee employee;

    @Column
    private String phone;

    public PhoneContact(Employee employee1, String phone1) {
        this.employee = employee1;
        this.phone = phone1;
    }

    public PhoneContact() {

    }
}
