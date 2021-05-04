package service;

import dao.DAO;
import entity.Pts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PtsService implements DAO<Pts,Integer> {

    private final SessionFactory factory;

    public PtsService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Pts pts) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(pts);
            session.getTransaction().commit();
            session.close();
        }

    }

    @Override
    public void update(Pts pts) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(pts);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(Pts pts) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(pts);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public Pts readById(Integer integer) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pts> generateContract() {
         try(Session session = factory.openSession()){
             Query<Pts> query = session.createQuery("From Pts");
             return query.list();
         }
    }
}
