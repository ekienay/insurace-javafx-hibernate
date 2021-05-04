package service;

import dao.DAO;
import entity.MarkTC;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class MarkTCService implements DAO<MarkTC,Integer> {

    private final SessionFactory factory;

    public MarkTCService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(MarkTC markTC) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(markTC);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void update(MarkTC markTC) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(markTC);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(MarkTC markTC) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(markTC);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public MarkTC readById(Integer integer) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MarkTC> generateContract() {
        try(Session session = factory.openSession()){
            Query<MarkTC> query = session.createQuery("From MarkTC");
            return query.list();
        }
    }
}
