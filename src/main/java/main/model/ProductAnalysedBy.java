package main.model;

import jakarta.persistence.*;

@Entity(name="ProductAnalysedBy")
@Table(name="productanalysedby")
public class ProductAnalysedBy {
    @Id
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    public ProductAnalysedBy(Product product1, Employee employee1) {
        this.product = product1;
        this.employee = employee1;
    }

    public ProductAnalysedBy() {

    }
}
