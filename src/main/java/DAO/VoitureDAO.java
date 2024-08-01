package DAO;

import Entity.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class VoitureDAO {
    private SessionFactory factory;
    public VoitureDAO() {
        factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Voiture.class).buildSessionFactory();
    }
    public void save(Voiture entity) {
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
    public List<Voiture> getAllVoitures() {
        Session session = factory.openSession();
        List<Voiture> list = null;
        try {
            list = session.createQuery("from Voiture", Voiture.class).list();
        } finally {
            session.close();
        }
        return list;
    }
}