package iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos;

import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.models.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findById(String id);
    Product findByName(String name);
}
