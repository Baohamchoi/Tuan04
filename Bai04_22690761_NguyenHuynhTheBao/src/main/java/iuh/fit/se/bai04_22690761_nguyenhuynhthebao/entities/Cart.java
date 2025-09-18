package iuh.fit.se.bai04_22690761_nguyenhuynhthebao.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    private int id;
    private Product product;
    private int quantity;

    public double totalPrice() {
        return product.getPrice() * quantity;
    }
}
