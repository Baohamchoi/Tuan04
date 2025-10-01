package iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao;

import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.model.Danhmuc;

public interface DanhMucDAO {
    Danhmuc findByName(String name);
}
