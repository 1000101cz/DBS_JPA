package main.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name="ProcessData")
@Table(name="processdata")
public class ProcessData {
    @Id
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @Column
    private String data_desc;

    @ElementCollection
    @Column
    private List<Double> process_data;

    public ProcessData(Product product1, String dataDesc1, List<Double> processData1) {
        this.product = product1;
        this.data_desc = dataDesc1;
        this.process_data = processData1;
    }

    public ProcessData(){

    }
}
