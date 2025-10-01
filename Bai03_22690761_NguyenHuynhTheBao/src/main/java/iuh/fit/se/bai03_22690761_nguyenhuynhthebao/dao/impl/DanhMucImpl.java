package iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao.impl;

import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao.DanhMucDAO;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.model.Danhmuc;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;

public class DanhMucImpl implements DanhMucDAO {
    @Override
    public Danhmuc findByName(String name) {
        try (EntityManager em = EntityManagerUtil.getEntitymanager()) {
            return em.createQuery("select d from Danhmuc d where d.tenDM = :name", Danhmuc.class)
                    .setParameter("name", name).getResultStream().findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
