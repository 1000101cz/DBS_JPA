package main.dao;

import main.model.ProductModel;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ProductModelDAO {
    private EntityManager em;

    public ProductModelDAO() {

    }

    public ProductModelDAO(EntityManager em) {
        this.em = em;
    }

    public List<ProductModel> findAll() {
        return em.createQuery("SELECT e FROM ProductModel e", ProductModel.class).getResultList();
    }

    void create(ProductModel e) {
        em.persist(e);
    }

    public ProductModel find(Long id) {
        return em.find(ProductModel.class, id);
    }

    public ProductModel merge(ProductModel e) {
        return em.merge(e);
    }

    public void delete(ProductModel e) {
        em.remove(e);
    }
}

