package iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos;

import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.models.Cart;

import java.util.List;

public interface CartDAO {
    boolean addItem(Cart cart);
    boolean updateItem(String id, int quantity);
    boolean deleteItem(String id);
    List<Cart> getCartItem();
    double totalOrder();
    int getLineCount();
}
