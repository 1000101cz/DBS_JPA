package main.model;

import jakarta.persistence.*;

@Entity(name="MachineOperatedBy")
@Table(name="machineoperatedby")
public class MachineOperatedBy {
    @Id
    @ManyToOne
    @JoinColumn(name = "machine")
    private Machine machine;

    @Id
    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    public MachineOperatedBy(Machine machine1, Employee employee1) {
        this.machine = machine1;
        this.employee = employee1;
    }

    public MachineOperatedBy() {

    }
}
