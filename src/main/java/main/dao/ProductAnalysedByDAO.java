package main.dao;

import main.model.Product;
import main.model.ProductAnalysedBy;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ProductAnalysedByDAO {
    private EntityManager em;

    public ProductAnalysedByDAO() {

    }

    public ProductAnalysedByDAO(EntityManager em) {
        this.em = em;
    }

    public List<ProductAnalysedBy> findAll() {
        return em.createQuery("SELECT e FROM ProductAnalysedBy e", ProductAnalysedBy.class).getResultList();
    }

    void create(ProductAnalysedBy e) {
        em.persist(e);
    }

    public ProductAnalysedBy find(Product prod) {
        return em.find(ProductAnalysedBy.class, prod);
    }

    public ProductAnalysedBy merge(ProductAnalysedBy e) {
        return em.merge(e);
    }

    public void delete(ProductAnalysedBy e) {
        em.remove(e);
    }
}
