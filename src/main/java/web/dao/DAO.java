package web.dao;

import web.models.Users;

import java.util.List;

public interface DAO {
    List<Users>index ();
    Users show(int id);
    void save(Users user);
    void delete(int id);
    void update(int id,Users user);
}
