package main.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name="Product")
@Table(name="product")
public class Product {
    @Id
    @Column
    @GeneratedValue
    private Long product_id;

    @Column
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "model")
    private ProductModel model;

    @ManyToOne
    @JoinColumn(name = "machine")
    private Machine machine;

    @Column
    private String result_state;

    public Product(LocalDateTime created1, ProductModel model1, Machine machine1, String resultState1) {
        this.created = created1;
        this.model = model1;
        this.machine = machine1;
        this.result_state = resultState1;
    }

    public Product() {

    }
}
