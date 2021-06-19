package service;

import dao.DAO;
import entity.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DriverService implements DAO<Driver> {

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
    @SuppressWarnings("unchecked")
    public List<Driver> findByAll() {
        try(Session session = factory.openSession()){
            List<Driver> driverList = session.createQuery("From Driver").list();
            return driverList;
        }
    }
}
