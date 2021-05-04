package service;

import dao.DAO;
import entity.DrvLicense;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DrvLicenseService implements DAO<DrvLicense, Integer> {

    private final SessionFactory factory;

    public DrvLicenseService(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(DrvLicense drvLicense) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(drvLicense);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void update(DrvLicense drvLicense) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(drvLicense);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(DrvLicense drvLicense) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(drvLicense);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public DrvLicense readById(Integer integer) {
        try(Session session = factory.openSession()){
            return session.get(DrvLicense.class, integer);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DrvLicense> generateContract() {
        try(Session session = factory.openSession()){
            Query<DrvLicense> query = session.createQuery("From DrvLicense");
            return query.list();
        }
    }
}
