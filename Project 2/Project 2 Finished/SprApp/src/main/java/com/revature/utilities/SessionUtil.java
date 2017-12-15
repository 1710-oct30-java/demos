package com.revature.utilities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class SessionUtil {
    private static SessionUtil su = new SessionUtil();
    private SessionFactory sf;
    {
        Configuration conf = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
                .build();
        // Build a session factory from the service registry
        sf = conf.buildSessionFactory(serviceRegistry);
    }
    private SessionUtil() {
        super();
    }
    public Session getSession() {
        return sf.openSession();
    }
	public static SessionUtil getSessionUtil() {
		return new SessionUtil();
	}
}