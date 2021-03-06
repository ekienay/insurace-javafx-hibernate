package service;

import dao.DAO;
import entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryService implements DAO<Category> {

    private final SessionFactory factory;

    public CategoryService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Category category) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void update(Category category) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(Category category) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(category);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findByAll() {
        try(Session session = factory.openSession()){
            Query<Category> query = session.createQuery("From Category");
            return query.list();
        }
    }
}
