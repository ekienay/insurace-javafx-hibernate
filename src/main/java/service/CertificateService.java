package service;

import dao.DAO;
import entity.Certificate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CertificateService implements DAO<Certificate> {

    private final SessionFactory factory;

    public CertificateService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Certificate certificate) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(certificate);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void update(Certificate certificate) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(certificate);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(Certificate certificate) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(certificate);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Certificate> findByAll() {
        try(Session session = factory.openSession()){
            Query<Certificate> query = session.createQuery("From Certificate");
            return query.list();
        }
    }
}
