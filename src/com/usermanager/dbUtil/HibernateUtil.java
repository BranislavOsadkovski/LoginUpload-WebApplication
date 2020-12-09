/**
 * Copyright the original author or authors.
 */
package com.usermanager.dbUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author Branislav
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getHibernateSession() {

		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure("cfg/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(builder.build());
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}

}
