package main.model;

import jakarta.persistence.*;

@Entity(name="ProductionLine")
@Table(name="productionline")
public class ProductionLine {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long line_id;

    @ManyToOne
    @JoinColumn(name = "plant")
    private ManufacturingPlant plant;

    @ManyToOne
    @JoinColumn(name = "master")
    private Employee master;

    @Column
    private Integer production_capacity;

    public ProductionLine(ManufacturingPlant plant1, Employee master1, int productionCapacity1) {
        this.plant = plant1;
        this.master = master1;
        this.production_capacity = productionCapacity1;
    }

    public ProductionLine() {

    }
}
