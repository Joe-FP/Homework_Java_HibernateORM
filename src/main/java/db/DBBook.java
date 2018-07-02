package db;

import models.Author;
import models.Book;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBBook {

    private static Session session;
    private static Transaction transaction;

    public static void save(Book book) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void update(Book book){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Book book) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Book> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Book> results = null;

        try {
            Criteria criteria = session.createCriteria(Book.class);
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Book find(int id) {
        Book result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Book.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Book) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static void deleteAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Book.class);
            List<Book> results = criteria.list();
            transaction = session.beginTransaction();
            for (Book book : results) {
                session.delete(book);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
