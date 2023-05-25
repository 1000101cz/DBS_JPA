package main.dao;

import main.model.ModelDevelopedBy;
import main.model.ProductModel;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ModelDevelopedByDAO {
    private EntityManager em;

    public ModelDevelopedByDAO() {

    }

    public ModelDevelopedByDAO(EntityManager em) {
        this.em = em;
    }

    public List<ModelDevelopedBy> findAll() {
        return em.createQuery("SELECT e FROM ModelDevelopedBy e", ModelDevelopedBy.class).getResultList();
    }

    void create(ModelDevelopedBy e) {
        em.persist(e);
    }

    public ModelDevelopedBy find(ProductModel model) {
        return em.find(ModelDevelopedBy.class, model);
    }

    public ModelDevelopedBy merge(ModelDevelopedBy e) {
        return em.merge(e);
    }

    public void delete(ModelDevelopedBy e) {
        em.remove(e);
    }
}
