package web.service;

import web.models.Users;

import java.util.List;

public interface UsersService {
    List<Users> index ();
    Users show(int id);
    void save(Users user);
    void delete(int id);
    void update(int id,Users user);
}
