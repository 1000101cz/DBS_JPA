package main.model;

import jakarta.persistence.*;

@Entity(name="EmployedIn")
@Table(name="employedin")
public class EmployedIn {
    @Id
    @ManyToOne
    @JoinColumn(name="employee")
    private Employee employee;

    @Id
    @ManyToOne
    @JoinColumn(name="plant")
    private ManufacturingPlant plant;

    public EmployedIn(Employee employee1, ManufacturingPlant plant1) {
        this.employee = employee1;
        this.plant = plant1;
    }

    public EmployedIn() {

    }

    // Gettery, settery
}
