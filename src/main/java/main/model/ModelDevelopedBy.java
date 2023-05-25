package main.model;

import jakarta.persistence.*;

@Entity(name="ModelDevelopedBy")
@Table(name="modeldevelopedby")
public class ModelDevelopedBy {
    @Id
    @ManyToOne
    @JoinColumn(name = "model")
    private ProductModel model;

    @Id
    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    public ModelDevelopedBy(ProductModel model1, Employee employee1) {
        this.model = model1;
        this.employee = employee1;
    }

    public ModelDevelopedBy() {

    }
}
