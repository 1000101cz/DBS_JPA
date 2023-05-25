package main.dao;

import main.model.EmployedIn;
import main.model.Employee;

import jakarta.persistence.EntityManager;
import java.util.List;

public class EmployedInDAO {
    private EntityManager em;

    public EmployedInDAO() {

    }

    public EmployedInDAO(EntityManager em) {
        this.em = em;
    }

    public List<EmployedIn> findAll() {
        return em.createQuery("SELECT e FROM EmployedIn e", EmployedIn.class).getResultList();
    }

    void create(EmployedIn e) {
        em.persist(e);
    }

    public EmployedIn find(Employee employee) {
        return em.find(EmployedIn.class, employee);
    }

    public EmployedIn merge(EmployedIn e) {
        return em.merge(e);
    }

    public void delete(Employee e) {
        em.remove(e);
    }
}
