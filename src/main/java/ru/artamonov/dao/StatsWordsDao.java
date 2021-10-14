package ru.artamonov.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.artamonov.entity.StatsWords;

public class StatsWordsDao {
    private final SessionFactory sessionFactory;

    public StatsWordsDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public StatsWords create(StatsWords statsWords) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            int id = (int)session.save(statsWords);
            statsWords.setId(id);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return statsWords;
    }

    public StatsWords read(int id) {
        StatsWords statsWords = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            statsWords = session.get(StatsWords.class, id);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return statsWords;
    }

    public boolean update(StatsWords statsWords) {
        boolean current = false;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(statsWords);
            session.getTransaction().commit();
            current = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return current;
    }

    public boolean delete(StatsWords statsWords) {
        boolean current = false;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(statsWords);
            session.getTransaction().commit();
            current = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return current;
    }
}
