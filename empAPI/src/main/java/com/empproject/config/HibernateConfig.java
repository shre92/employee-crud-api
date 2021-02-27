package com.empproject.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.empproject.config"})
@PropertySource("classpath:application.properties")
public class HibernateConfig {
	@Resource
	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setPackagesToScan(new String[] {"com.empproject.model"});
		return sessionFactoryBean;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("orm.dialect"));
		properties.put("hibernate.show_sql", "false");
		properties.put("hibernate.format_sql", "false");
		return properties;
	}
	

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("mysql.driver"));
		ds.setUrl(env.getProperty("mysql.url"));
		ds.setUsername(env.getProperty("mysql.username"));
		ds.setPassword(env.getProperty("mysql.password"));
		return ds;
	}
	
	@Bean
	public HibernateTransactionManager txManager(SessionFactory sf) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sf);
		return transactionManager;
	}
}
