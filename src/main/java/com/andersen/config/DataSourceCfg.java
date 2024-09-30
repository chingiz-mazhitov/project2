package com.andersen.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db/jdbc.properties")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataSourceCfg {

	@Value("${jdbc.driverClassName}")
	String driverClassName;

	@Value("${jdbc.url}")
	String url;

	@Value("${jdbc.username}")
	String username;

	@Value("${jdbc.password}")
	String password;

	@Bean
	public DataSource dataSource() {
		try {
			var hc = new HikariConfig();
			hc.setJdbcUrl(url);
			hc.setDriverClassName(driverClassName);
			hc.setUsername(username);
			hc.setPassword(password);

			var dataSource = new HikariDataSource(hc);
			dataSource.setMaximumPoolSize(10);
			return dataSource;
		} catch (Exception e) {
			log.error("Hikari DataSource bean cannot be created!");
			return null;
		}
	}

}
