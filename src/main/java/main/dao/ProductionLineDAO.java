package main.dao;

import main.model.ManufacturingPlant;
import main.model.ProcessData;
import main.model.ProductionLine;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ProductionLineDAO {
    private EntityManager em;

    public ProductionLineDAO() {

    }

    public ProductionLineDAO(EntityManager em) {
        this.em = em;
    }

    public List<ProductionLine> findAll() {
        return em.createQuery("SELECT e FROM ProductionLine e", ProductionLine.class).getResultList();
    }

    void create(ProductionLine e) {
        em.persist(e);
    }

    public ProductionLine find(Long id) {
        return em.find(ProductionLine.class, id);
    }

    public ProductionLine merge(ProductionLine e) {
        return em.merge(e);
    }

    public void delete(ProductionLine e) {
        em.remove(e);
    }
}
