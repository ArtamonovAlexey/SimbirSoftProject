package ru.artamonov.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.artamonov.entity.Url;

public class UrlDao {
    private final SessionFactory sessionFactory;

    public UrlDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Url create(Url url) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            int id = (int) session.save(url);
            url.setId(id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }

    public Url read(int id) {
        Url url = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            url = session.get(Url.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }

    public boolean update(Url url) {
        boolean currect = false;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(url);
            session.getTransaction().commit();
            currect = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currect;
    }

    public boolean delete(Url url) {
        boolean currect = false;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(url);
            session.getTransaction().commit();
            currect = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currect;
    }
}
