package com.ejemplos.spring.config;



import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ejemplos.spring.model.Categorias;
import com.ejemplos.spring.model.Departamentos;
import com.ejemplos.spring.model.Direcciones;
import com.ejemplos.spring.model.Empleados;
import com.ejemplos.spring.model.Personas;
import com.ejemplos.spring.model.Telefonos;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.ejemplos.spring")
public class AppConfigContext {

	@Bean(name ="viewResolver")
	public InternalResourceViewResolver getViewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// -----------------------DATA SOURCE-------------------------

	@Bean(name ="dataSource")
	public DataSource getDataSource(){
		
		BasicDataSource dSource = new BasicDataSource(); 
		dSource.setDriverClassName("com.mysql.jdbc.Driver");
		dSource.setUrl("jdbc:mysql://localhost:3306/agenda");
		dSource.setUsername("root");
		dSource.setPassword("1111");
		
		return dSource;
		
	}
	
	//-------------------HIBERNATE PROPERTIES-----------------------
	
//	private Properties getHibernateProperties(){
//		Properties prop = new Properties();
//		prop.put("hibernate.show_sql", "true");
//		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		
//		return prop;
//	}
	//------------------SESSION FACTORY-----------------------------
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sesBuilder = new LocalSessionFactoryBuilder(dataSource);
//		sesBuilder.setProperties(getHibernateProperties());
		
		sesBuilder.addAnnotatedClasses(Categorias.class);
		sesBuilder.addAnnotatedClass(Departamentos.class);
		sesBuilder.addAnnotatedClass(Direcciones.class);
		sesBuilder.addAnnotatedClass(Empleados.class);
		sesBuilder.addAnnotatedClass(Personas.class);
		sesBuilder.addAnnotatedClass(Telefonos.class);
		
		return sesBuilder.buildSessionFactory();
		
	}
	
	
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(@Autowired SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
	
}
