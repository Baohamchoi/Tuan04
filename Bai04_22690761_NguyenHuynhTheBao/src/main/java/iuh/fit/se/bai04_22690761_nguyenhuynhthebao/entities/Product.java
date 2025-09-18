package iuh.fit.se.bai04_22690761_nguyenhuynhthebao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Product {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;
    private float price;
    private int stock;

    @Lob // báo cho JPA/Hibernate biết đây là kiểu dữ liệu lớn
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image; // Lưu ảnh dưới dạng chuỗi nhị phân
}
