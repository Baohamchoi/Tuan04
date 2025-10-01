package iuh.fit.se.bai03_22690761_nguyenhuynhthebao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tintuc")
public class Tintuc {
    @Id
    @Column(name="MATT")
    // id tự động tăng từ id max trong data, nhưng phải setting id trong database là AUTO_INCREMENT
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matt;
    @Column(name="TIEUDE")
    private String tieuDe;
    @Column(name="NOIDUNGTT")
    private String noiDungTT;
    @Column(name="MADM")
    private int maDM;
    @Column(name="NGAYDANG")
    private LocalDate ngayDang;
}
