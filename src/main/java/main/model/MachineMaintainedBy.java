package main.model;

import jakarta.persistence.*;

@Entity(name="MachineMaintainedBy")
@Table(name="machinemaintainedby")
public class MachineMaintainedBy {
    @Id
    @ManyToOne
    @JoinColumn(name = "machine")
    private Machine machine;

    @Id
    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    public MachineMaintainedBy(Machine machine1, Employee employee1) {
        this.machine = machine1;
        this.employee = employee1;
    }

    public MachineMaintainedBy() {

    }

    // Gettery, settery
}
