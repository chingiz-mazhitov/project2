package com.andersen.config;

import com.andersen.entity.Client;
import com.andersen.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JDBCConfig {

	public static final String HIBERNATE_CFG_XML = "hibernate.cfg.mxl";

	public static SessionFactory getSessionFactory() {
		return new Configuration()
				.configure(HIBERNATE_CFG_XML)
				.addPackage("com.andersen.entity")
				.buildSessionFactory();
	}
}
