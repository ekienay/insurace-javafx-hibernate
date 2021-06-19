package service;

import dao.DAO;
import entity.TypeEngine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TypeEngineService implements DAO<TypeEngine> {

    private final SessionFactory factory;

    public TypeEngineService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(TypeEngine typeEngine) {

    }

    @Override
    public void update(TypeEngine typeEngine) {

    }

    @Override
    public void delete(TypeEngine typeEngine) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TypeEngine> findByAll() {
        try (Session session = factory.openSession()) {
            Query<TypeEngine> query = session.createQuery("From TypeEngine");
            return query.list();
        }
    }
}