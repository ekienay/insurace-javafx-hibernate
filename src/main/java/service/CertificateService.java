package service;

import dao.DAO;
import entity.Certificate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CertificateService implements DAO<Certificate,Integer> {

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
    public Certificate readById(Integer integer) {
        try(Session session = factory.openSession()){
            return session.get(Certificate.class,integer);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Certificate> generateContract() {
        try(Session session = factory.openSession()){
            Query<Certificate> query = session.createQuery("From Certificate");
            return query.list();
        }
    }
}
