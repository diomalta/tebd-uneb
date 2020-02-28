package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        Configuration config = new Configuration();
        Path hibernateXml = Paths.get(System.getProperty("user.dir"),"src", "hibernate.cfg.xml");
        config.configure(new File(hibernateXml.toString()));
        sessionFactory = config.buildSessionFactory();
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {  session.close(); }
    }
}