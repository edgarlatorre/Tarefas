package br.com.edgarlatorre.tarefas.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraBanco {
	public static void main(String[] args) {
		Configuration conf = new AnnotationConfiguration();
		conf.configure();
		SchemaExport schemaExport = new SchemaExport(conf);
		schemaExport.create(true, true);
	}
}
