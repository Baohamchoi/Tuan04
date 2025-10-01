package iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao;

import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.model.Tintuc;

import java.util.List;

public interface TinTucDAO {
    List<Tintuc> getAll();
    Tintuc getById(String id);
    void save(Tintuc tintuc);
    void delete(String id);
}
