package iuh.fit.se.bai04_22690761_nguyenhuynhthebao.daos;

import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.entities.Cart;

import java.util.List;

public interface CartDAO {
    boolean addItem(Cart cart);
    boolean updateItem(String id, int quantity);
    boolean deleteItem(String id);
    List<Cart> getCartItem();
    double totalOrder();
    int getLineCount();
}
