package com.bhs.onlineayurvedaback.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.bsh.onlineayurvedaback.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "SA";
	private final static String DATABASE_PASSWORD = "";

	// dataSource bean will be available
	@Bean("dataSource")
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		// providing databse connection info

		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;

	}

	// sessionFactory bean will be available
	@Bean
	public SessionFactory getsessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.bhs.onlineayurvedaback.dto");

		return builder.buildSessionFactory();
	}

	// all hibernate properties will be returned in ths method
	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory SessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(SessionFactory);
		return transactionManager;

	}

}
