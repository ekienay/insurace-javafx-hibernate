package service;

import dao.DAO;
import entity.Agent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AgentService implements DAO<Agent> {
    private final SessionFactory factory;

    public AgentService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Agent agent) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(agent);
            session.getTransaction().commit();
            session.close();
        }

    }

    @Override
    public void update(Agent agent) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(agent);
            session.getTransaction().commit();
            session.close();
        }

    }

    @Override
    public void delete(Agent agent) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(agent);
            session.getTransaction().commit();
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Agent> findByAll() {
        try(Session session = factory.openSession()){
            List<Agent> agentList = session.createQuery("From Agent").list();
            session.close();
            return agentList;
        }
    }
}
