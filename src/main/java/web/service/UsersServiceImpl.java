package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DAO;
import web.models.Users;
import javax.validation.Valid;
import java.util.List;

import java.util.List;
@Service
@Transactional
public class UsersServiceImpl implements  UsersService{

    private final DAO dao;

    @Autowired
    public UsersServiceImpl(DAO dao) {
        this.dao = dao;
    }
    @Override
    public List<Users> index() {
        return dao.index();
    }

    @Override
    public Users show(int id) {
        return dao.show(id);
    }

    @Override
    public void save(Users user) {
        dao.save(user);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(int id, Users user) {
        dao.update(id, user);
    }
}
