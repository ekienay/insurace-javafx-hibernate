package service;

import dao.DAO;
import entity.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DriverService implements DAO<Driver, Integer> {

    private final SessionFactory factory;

    public DriverService(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public void create(Driver driver) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(driver);
            session.getTransaction().commit();
            session.close();
        }
    }
    @Override
    public void update(Driver driver) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(driver);
            session.getTransaction().commit();
            session.close();
        }
    }
    @Override
    public void delete(Driver driver) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(driver);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public Driver readById(Integer integer) {
        try(Session session = factory.openSession()){
            return session.get(Driver.class, integer);

        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Driver> generateContract() {
        try(Session session = factory.openSession()){
            List<Driver> driverList = session.createQuery("From Driver").list();
            session.close();
            return driverList;
        }
    }
}
