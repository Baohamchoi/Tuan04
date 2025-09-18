package iuh.fit.se.bai04_22690761_nguyenhuynhthebao.daos.impl;

import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.daos.ProductDAO;
import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.entities.Product;
import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.ultis.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> findAll() {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            Query query = em.createNativeQuery("select * from products", Product.class);
            List<Product> products = query.getResultList();
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean save(String id) {
        return false;
    }

    @Override
    public Product findById(String id) {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            return em.find(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Product findByName(String name) {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()){
            return em.find(Product.class, name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
