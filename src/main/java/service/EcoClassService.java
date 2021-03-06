package service;

import dao.DAO;
import entity.EcoClass;
import entity.TypeTC;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EcoClassService implements DAO<EcoClass> {

    private final SessionFactory factory;

    public EcoClassService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(EcoClass ecoClass) {

    }

    @Override
    public void update(EcoClass ecoClass) {

    }

    @Override
    public void delete(EcoClass ecoClass) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<EcoClass> findByAll() {
        try(Session session = factory.openSession()){
            Query<EcoClass> query = session.createQuery("From EcoClass");
            return query.list();
        }
    }
}
