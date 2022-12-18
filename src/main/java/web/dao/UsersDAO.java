package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.Users;

import java.util.List;


@Component
public class UsersDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UsersDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Users> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Users p", Users.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Users show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Users.class, id);
    }

    @Transactional
    public void save(Users person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Transactional
    public void update(int id, Users updatedPerson) {
        Session session = sessionFactory.getCurrentSession();
        Users personToBeUpdated = session.get(Users.class, id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Users.class, id));
    }
}
