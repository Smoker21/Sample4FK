package com.rainty.fk.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * A sample Dbconfiguration for H2 embedded database. It's for demo and test purpose. 
 * Not for production. 
 * For Production purpose, please use OracleDbconfig
 * @author Lance
 *
 */
@Configuration
public class H2DatabaseConfig {

	/**
	 * A sample datasource for pooled embedded H2 Database. The datasource is
	 * for demo purpose.
	 * 
	 * @return Datasource
	 */
	@Bean(destroyMethod = "shutdown")
	public EmbeddedDatabase h2DataSource() {
		EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2).addScript("initial_db.sql")
				.build();
		return database;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setDataSource(h2DataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

}
