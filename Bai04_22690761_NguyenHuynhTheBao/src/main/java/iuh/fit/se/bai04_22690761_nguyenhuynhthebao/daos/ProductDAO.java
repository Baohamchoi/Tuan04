package iuh.fit.se.bai04_22690761_nguyenhuynhthebao.daos;

import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.entities.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    boolean update (Product product);
    boolean save (String id);
    Product findById(String id);
    Product findByName(String name);
}
