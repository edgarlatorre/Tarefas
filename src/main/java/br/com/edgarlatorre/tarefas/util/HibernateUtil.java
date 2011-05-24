package br.com.edgarlatorre.tarefas.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	public static SessionFactory getSessionFactory(){
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		return configuration.buildSessionFactory();
	}
}
