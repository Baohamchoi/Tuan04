package iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos.Impl;

import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos.CartDAO;
import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.models.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartImpl implements CartDAO {
    private List<Cart> items = new ArrayList<Cart>();

    @Override
    public boolean addItem(Cart cart) {
        return items.add(cart);
    }

    @Override
    public boolean updateItem(String id, int quantity) {
        Cart cart = items.stream().filter(x -> x.getId() == Integer.parseInt(id)).findFirst().orElse(null);

        if (cart == null) {
            return false;
        } else {
            cart.setQuantity(quantity);
            return true;
        }
    }

    @Override
    public boolean deleteItem(String id) {
        return items.removeIf(x -> x.getId() == Integer.parseInt(id));
    }

    @Override
    public List<Cart> getCartItem() {
        return items;
    }

    @Override
    public double totalOrder() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            Cart cart = items.get(i);
            total = total + cart.getTotalPrice();
        }
        return total;
    }

    @Override
    public int getLineCount() {
        return items.size();
    }
}
