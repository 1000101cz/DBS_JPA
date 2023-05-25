package main.dao;

import main.model.PhoneContact;
import main.model.ProcessData;
import main.model.Product;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ProcessDataDAO {
    private EntityManager em;

    public ProcessDataDAO() {

    }

    public ProcessDataDAO(EntityManager em) {
        this.em = em;
    }

    public List<ProcessData> findAll() {
        return em.createQuery("SELECT e FROM ProcessData e", ProcessData.class).getResultList();
    }

    void create(ProcessData e) {
        em.persist(e);
    }

    public ProcessData find(Product prod) {
        return em.find(ProcessData.class, prod);
    }

    public ProcessData merge(ProcessData e) {
        return em.merge(e);
    }

    public void delete(ProcessData e) {
        em.remove(e);
    }
}
