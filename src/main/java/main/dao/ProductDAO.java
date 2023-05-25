package main.dao;

import main.model.Machine;
import main.model.Product;
import main.model.ProductAnalysedBy;
import main.model.ProductModel;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ProductDAO {
    private EntityManager em;

    public ProductDAO() {

    }

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT e FROM Product e", Product.class).getResultList();
    }

    void create(Product e) {
        em.persist(e);
    }

    public Product find(Long id) {
        return em.find(Product.class, id);
    }

    public Product merge(Product e) {
        return em.merge(e);
    }

    public void delete(Product e) {
        em.remove(e);
    }
}
