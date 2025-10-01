package iuh.fit.se.bai03_22690761_nguyenhuynhthebao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "danhmuc")
public class Danhmuc {
    @Id
    @Column(name = "MADM")
    private int maDM;

    @Column(name = "TENDANHMUC")
    private String tenDM;
    @Column(name = "NGUOIQUANLY")
    private String nguoiQL;
    @Column(name = "GHICHU")
    private String ghiChu;
}
