package com.test.app;


import com.test.dao.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Main {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        System.out.println("=====Первая сессия и 2 одинаковых запроса----------------------");

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Task task = session.load(Task.class, new Integer(4));
        System.out.println(task);

        task = session.load(Task.class, new Integer(4));
        System.out.println(task);

        session.getTransaction().commit();
        session.close();

        System.out.println("=====Вторая сессия и тот же запрос----------------------");
        session = sessionFactory.openSession();
        session.beginTransaction();
        task = session.load(Task.class, new Integer(4));
        System.out.println(task);
        session.getTransaction().commit();
        session.close();
    }
}
