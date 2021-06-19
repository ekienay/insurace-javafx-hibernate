package service;

import dao.DAO;
import entity.ModelTC;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ModelTCService implements DAO<ModelTC> {
    private final SessionFactory factory;

    public ModelTCService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(ModelTC modelTC) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(modelTC);
            session.getTransaction().commit();
            session.close();
        }

    }

    @Override
    public void update(ModelTC modelTC) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(modelTC);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(ModelTC modelTC) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(modelTC);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelTC> findByAll() {
        try(Session session = factory.openSession()){
            Query<ModelTC> query = session.createQuery("From ModelTC");
            return query.list();
        }
    }
}
