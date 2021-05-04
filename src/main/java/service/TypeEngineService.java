package service;

import dao.DAO;
import entity.TypeEngine;
import entity.TypeTC;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TypeEngineService implements DAO<TypeEngine,Integer> {

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
    public TypeEngine readById(Integer integer) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TypeEngine> generateContract() {
        try (Session session = factory.openSession()) {
            Query<TypeEngine> query = session.createQuery("From TypeEngine");
            return query.list();
        }
    }
}