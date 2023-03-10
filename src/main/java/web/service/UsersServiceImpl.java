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

public class UsersServiceImpl implements  UsersService{

    private final DAO dao;


    public UsersServiceImpl(DAO dao) {
        this.dao = dao;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Users> index() {
        return dao.index();
    }

    @Override
    @Transactional(readOnly = true)
    public Users show(int id) {
        return dao.show(id);
    }

    @Override
    @Transactional
    public void save(Users user) {
        dao.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void update(int id, Users user) {
        dao.update(id, user);
    }
}
