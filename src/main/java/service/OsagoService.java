package service;

import dao.DAO;
import entity.Osago;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class OsagoService implements DAO<Osago> {

    private final SessionFactory factory;

    public OsagoService(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public void create(Osago osago) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(osago);
            session.getTransaction().commit();
            session.close();
        }
    }
    @Override
    public void update(Osago osago) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(osago);
            session.getTransaction().commit();
            session.close();
        }
    }
    @Override
    public void delete(Osago osago) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(osago);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Osago> findByAll() {
        try(Session session = factory.openSession()){
            Query<Osago> query = session.createQuery("From Osago");
            return query.list();
        }
    }
}
