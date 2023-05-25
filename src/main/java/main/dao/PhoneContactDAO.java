package main.dao;

import main.model.Employee;
import main.model.PhoneContact;

import jakarta.persistence.EntityManager;
import java.util.List;

public class PhoneContactDAO {
    private EntityManager em;

    public PhoneContactDAO() {

    }

    public PhoneContactDAO(EntityManager em) {
        this.em = em;
    }

    public List<PhoneContact> findAll() {
        return em.createQuery("SELECT e FROM PhoneContact e", PhoneContact.class).getResultList();
    }

    void create(PhoneContact e) {
        em.persist(e);
    }

    public PhoneContact find(Employee emp) {
        return em.find(PhoneContact.class, emp);
    }

    public PhoneContact merge(PhoneContact e) {
        return em.merge(e);
    }

    public void delete(PhoneContact e) {
        em.remove(e);
    }
}
