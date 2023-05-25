package main.dao;

import main.model.MachineOperatedBy;
import main.model.ManufacturingPlant;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ManufacturingPlantDAO {
    private EntityManager em;

    public ManufacturingPlantDAO() {

    }

    public ManufacturingPlantDAO(EntityManager em) {
        this.em = em;
    }

    public List<ManufacturingPlant> findAll() {
        return em.createQuery("SELECT e FROM ManufacturingPlant e", ManufacturingPlant.class).getResultList();
    }

    void create(ManufacturingPlant e) {
        em.persist(e);
    }

    public ManufacturingPlant find(Long id) {
        return em.find(ManufacturingPlant.class, id);
    }

    public ManufacturingPlant merge(ManufacturingPlant e) {
        return em.merge(e);
    }

    public void delete(ManufacturingPlant e) {
        em.remove(e);
    }

    public void printAllPlantsList() {
        System.out.println("List of all manufacturing plants:\n");
        List<ManufacturingPlant> all_plants = this.findAll();
        for (ManufacturingPlant plant : all_plants) {
            System.out.println(plant.getCity() + " - " + plant.getStreet() + " " + plant.getZip() + " [" + plant.getPlant_id() + "]");
        }
        System.out.println("-----------------------------");
    }
}
