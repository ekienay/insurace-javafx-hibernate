package service;

import dao.DAO;
import entity.TypeTC;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TypeTCService implements DAO<TypeTC> {

    private final SessionFactory factory;

    public TypeTCService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(TypeTC typeTC) {
    }

    @Override
    public void update(TypeTC typeTC) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(typeTC);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(TypeTC typeTC) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TypeTC> findByAll() {
        try(Session session = factory.openSession()){
            Query<TypeTC> query = session.createQuery("From TypeTC");
            return query.list();
        }
    }
}
