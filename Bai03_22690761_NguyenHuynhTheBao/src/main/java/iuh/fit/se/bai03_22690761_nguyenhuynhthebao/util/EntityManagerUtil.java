package iuh.fit.se.bai03_22690761_nguyenhuynhthebao.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("news-management");
    }

    public static EntityManager getEntitymanager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close() {
        if(entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
