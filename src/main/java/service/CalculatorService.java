package service;

import dao.DAO;
import entity.Calculator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CalculatorService  implements DAO<Calculator> {

    private final SessionFactory factory;

    public CalculatorService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Calculator calculator) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(calculator);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void update(Calculator calculator) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(calculator);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(Calculator calculator) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(calculator);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Calculator> findByAll() {
        try(Session session = factory.openSession()){
            Query<Calculator> query = session.createQuery("From Calculator");
            return query.list();
        }
    }
}
