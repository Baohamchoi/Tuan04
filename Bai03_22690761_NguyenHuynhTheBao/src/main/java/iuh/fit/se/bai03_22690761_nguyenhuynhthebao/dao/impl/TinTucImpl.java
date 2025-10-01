package iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao.impl;

import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao.TinTucDAO;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.model.Tintuc;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TinTucImpl implements TinTucDAO {

    @Override
    public List<Tintuc> getAll() {
        try (EntityManager em = EntityManagerUtil.getEntitymanager()) {
            return em.createQuery("from Tintuc", Tintuc.class).getResultList();
        }
    }

    @Override
    public Tintuc getById(String id) {
        return null;
    }

    @Override
    public void save(Tintuc tintuc) {
        try (EntityManager em = EntityManagerUtil.getEntitymanager()) {
            em.getTransaction().begin();
            em.merge(tintuc);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {

    }
}
