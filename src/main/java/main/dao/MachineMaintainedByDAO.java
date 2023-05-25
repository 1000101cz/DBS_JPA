package main.dao;

import main.model.*;

import jakarta.persistence.EntityManager;
import java.util.List;

public class MachineMaintainedByDAO {
    private EntityManager em;

    public MachineMaintainedByDAO() {

    }

    public MachineMaintainedByDAO(EntityManager em) {
        this.em = em;
    }

    public List<MachineMaintainedBy> findAll() {
        return em.createQuery("SELECT e FROM MachineMaintainedBy e", MachineMaintainedBy.class).getResultList();
    }

    void create(MachineMaintainedBy e) {
        em.persist(e);
    }

    public MachineMaintainedBy find(Machine machine) {
        return em.find(MachineMaintainedBy.class, machine);
    }

    public MachineMaintainedBy merge(MachineMaintainedBy e) {
        return em.merge(e);
    }

    public void delete(MachineMaintainedBy e) {
        em.remove(e);
    }
}
