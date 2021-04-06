package com.company;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseManager {
    private static SessionFactory factory;

    public DatabaseManager() {
        try {
            factory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Country.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public List<Country> getCountries() {
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Country").list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return new ArrayList<>();
    }

    public void save(Object item) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
           tx = session.beginTransaction();
           session.save(item);
           tx.commit();
        } catch (HibernateException ex) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(ex);
        } finally {
            session.close();
        }
    }

    public void testMethod8(){

    }

    public void update(Object item) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(item);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(ex);
        } finally {
            session.close();
        }
    }

    public void updateCountry(Country country) {
        if(country.getId() == 0) {
            return;
        }

        update(country);
    }

    public void delete(Object item) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(item);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(ex);
        } finally {
            session.close();
        }
    }

    public Country getById(int id) {
        var session = factory.openSession();

        try {
            return session.get(Country.class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return null;
    }

    public List<Country> getCountriesFromView() {
        var session = factory.openSession();

        try {

            String sql = "select * FROM vgetcountriesstartinga";
            var query = session.createSQLQuery(sql);

            var result = query.list().stream()
                    .map(item -> mapToCountry(item))
                    .collect(Collectors.toList());

            int a = 1;

            return (ArrayList<Country>)result;

        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return new ArrayList<>();
    }

    private Country mapToCountry(Object obj) {
        var row = (Object[]) obj;
        return new Country((int)row[0], (String)row[1], (String)row[2]);
    }

    public void testMethod(){

    }

    public void testMethodTwo(){

    }

    public void testMethod3 () {

    }

    public void testMethod4(){

    }

    public void testMethod5() {

    }

    public void testMethod6(){

    }

    public void testMethod7() {

    }
}
