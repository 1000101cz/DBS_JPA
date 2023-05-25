package main.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name="ProductModel")
@Table(name = "productmodel")
public class ProductModel {
    @Id
    @GeneratedValue
    @Column
    private Long model_id;

    @Column(nullable = false)
    private String product_type;

    @Column(nullable = false)
    private int modelVersion;

    public ProductModel() {
    }

    public ProductModel(String productType, int modelVersion) {
        this.product_type = productType;
        this.modelVersion = modelVersion;
    }

    public Long getId() {
        return model_id;
    }

    public String getProductType() {
        return product_type;
    }

    public void setProductType(String productType) {
        this.product_type = productType;
    }

    public int getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(int modelVersion) {
        this.modelVersion = modelVersion;
    }
}
