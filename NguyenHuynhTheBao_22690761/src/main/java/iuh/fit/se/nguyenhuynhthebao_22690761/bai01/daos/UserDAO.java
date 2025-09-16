package iuh.fit.se.nguyenhuynhthebao_22690761.bai01.daos;

import iuh.fit.se.nguyenhuynhthebao_22690761.bai01.entities.User;

import java.util.List;

public interface UserDAO {
    boolean save(User user);
    List<User> findAll();
    boolean update(User user);
    boolean delete(String id);
}
