package main.model;

import jakarta.persistence.*;

@Entity(name="Intern")
@Table(name="intern", schema="public", catalog="maroust1")
@PrimaryKeyJoinColumn(name="employee_id")
@DiscriminatorValue("0")
public class Intern extends Employee {
    @Column(name="school")
    private String school;

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String sch) {
        this.school = sch;
    }
}
