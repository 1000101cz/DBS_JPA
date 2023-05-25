package main.model;

import jakarta.persistence.*;

@Entity(name="Machine")
@Table(name="machine")
public class Machine {
    @Id
    @GeneratedValue
    @Column(name="machine_id")
    private Long id;

    @Column
    private String machine_type;

    @ManyToOne
    @JoinColumn(name = "line_id")
    private ProductionLine line;

    @ManyToOne
    @JoinColumn(name="master")
    private Employee master;

    public Machine(String machineType1, ProductionLine line1, Employee master1) {
        this.machine_type = machineType1;
        this.line = line1;
        this.master = master1;
    }

    public Machine() {
    }
}
