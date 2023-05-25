package main.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity(name="ManufacturingPlant")
@Table(name="manufacturingplant")
public class ManufacturingPlant {
    @Id
    @GeneratedValue
    private Long plant_id;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private Integer zip;
    @Column
    private LocalDate established;

    @ManyToMany
    @JoinTable(
            name = "EmployedAt",
            joinColumns = @JoinColumn(name = "manufacturingplant", referencedColumnName = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "employee", referencedColumnName = "employee_id")
    )
    private List<Employee> employees;

    public ManufacturingPlant(String s, String s1, int i, LocalDate of) {
        this.street = s;
        this.city = s1;
        this.zip = i;
        this.established = of;
    }

    public ManufacturingPlant() {
    }

    public Long getPlant_id() {
        return this.plant_id;
    }

    public String getCity() {
        return this.city;
    }

    public String getStreet() {
        return this.street;
    }

    public Integer getZip() {
        return this.zip;
    }
}
