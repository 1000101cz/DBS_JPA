package main.dao;

import main.model.Machine;

import jakarta.persistence.EntityManager;
import java.util.List;

public class MachineDAO {
    private EntityManager em;

    public MachineDAO() {

    }

    public MachineDAO(EntityManager em) {
        this.em = em;
    }

    public List<Machine> findAll() {
        return em.createQuery("SELECT e FROM Machine e", Machine.class).getResultList();
    }

    void create(Machine e) {
        em.persist(e);
    }

    public Machine find(Long id) {
        return em.find(Machine.class, id);
    }

    public Machine merge(Machine e) {
        return em.merge(e);
    }

    public void delete(Machine e) {
        em.remove(e);
    }
}
