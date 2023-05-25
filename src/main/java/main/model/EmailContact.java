package main.model;

import jakarta.persistence.*;

@Entity(name="EmailContact")
@Table(name="emailcontact")
public class EmailContact {
    @Id
    @ManyToOne
    @JoinColumn(name="employee")
    private Employee employee;

    @Column
    private String email;

    public EmailContact(Employee employee1, String mail) {
        this.employee = employee1;
        this.email = mail;
    }

    public EmailContact() {

    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee e) {
        this.employee = e;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String e) {
        this.email = e;
    }
}
