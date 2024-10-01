package com.andersen.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Import(DataSourceCfg.class)
@ComponentScan(basePackages = {"com.andersen"})
@EnableTransactionManagement
public class JpaConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public PlatformTransactionManager transactionManager() {
		var transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		var factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("com.andersen.entity");
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setJpaProperties(jpaProperties());
		return factory;
	}

	@Bean
	public Properties jpaProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.put(Environment.SHOW_SQL, false);
		jpaProperties.put(Environment.FORMAT_SQL, false);
		jpaProperties.put(Environment.HBM2DDL_AUTO, "none");
		jpaProperties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

		return jpaProperties;
	}
}
