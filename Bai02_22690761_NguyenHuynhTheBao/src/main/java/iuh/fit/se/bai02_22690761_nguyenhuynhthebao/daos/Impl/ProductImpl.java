package iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos.Impl;

import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos.ProductDAO;
import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.models.Product;
import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.ultis.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductImpl implements ProductDAO {
    @Override
    public List<Product> findAll() {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            return em.createQuery("select p from Product p", Product.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public Product findById(String id) {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            return em.find(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            return em.find(Product.class, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
