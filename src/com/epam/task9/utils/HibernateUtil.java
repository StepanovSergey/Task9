package com.epam.task9.utils;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Siarhei_Stsiapanau
 * 
 */
public final class HibernateUtil {
    private static final Logger log = Logger.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory = buildSessionFactory();
    
    public HibernateUtil(){
    }

    private static SessionFactory buildSessionFactory() {
	try {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
		    .applySettings(configuration.getProperties())
		    .buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	} catch (HibernateException ex) {
	    log.error(ex.getMessage(), ex);
	    ex.printStackTrace();
	}
	return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
	return sessionFactory;
    }
}
