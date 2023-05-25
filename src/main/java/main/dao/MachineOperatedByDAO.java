package main.dao;

import main.model.Machine;
import main.model.MachineOperatedBy;

import jakarta.persistence.EntityManager;
import java.util.List;

public class MachineOperatedByDAO {
    private EntityManager em;

    public MachineOperatedByDAO() {

    }

    public MachineOperatedByDAO(EntityManager em) {
        this.em = em;
    }

    public List<MachineOperatedBy> findAll() {
        return em.createQuery("SELECT e FROM MachineOperatedBy e", MachineOperatedBy.class).getResultList();
    }

    void create(MachineOperatedBy e) {
        em.persist(e);
    }

    public MachineOperatedBy find(Machine machine) {
        return em.find(MachineOperatedBy.class, machine);
    }

    public MachineOperatedBy merge(MachineOperatedBy e) {
        return em.merge(e);
    }

    public void delete(MachineOperatedBy e) {
        em.remove(e);
    }
}
