package com.ahtacode.playermarkt.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

  private final PersistenceUnitManager persistenceUnitManager;

  public DataSourceConfiguration(ObjectProvider<PersistenceUnitManager> persistenceUnitManager) {
    this.persistenceUnitManager = persistenceUnitManager.getIfAvailable();
  }

  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource.db.jpa")
  public JpaProperties primaryJpaProperties() {
    return new JpaProperties();
  }

  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource.db")
  public DataSourceProperties primaryDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.db")
  public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean primaryEntityManager(
      JpaProperties customerJpaProperties) {
    EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(customerJpaProperties);
    return builder.dataSource(primaryDataSource()).packages("com.ahtacode.playermarkt.data.entity")
        .persistenceUnit("primaryDs").build();
  }

  @Bean
  @Primary
  public JpaTransactionManager primaryTransactionManager(
      EntityManagerFactory customerEntityManager) {
    return new JpaTransactionManager(customerEntityManager);
  }

  private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(
      JpaProperties customerJpaProperties) {
    JpaVendorAdapter jpaVendorAdapter = createJpaVendorAdapter(customerJpaProperties);
    return new EntityManagerFactoryBuilder(jpaVendorAdapter, customerJpaProperties.getProperties(),
        this.persistenceUnitManager);
  }

  private JpaVendorAdapter createJpaVendorAdapter(JpaProperties jpaProperties) {
    AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setShowSql(jpaProperties.isShowSql());
    adapter.setDatabase(jpaProperties.getDatabase());
    adapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
    adapter.setGenerateDdl(jpaProperties.isGenerateDdl());
    return adapter;
  }

  @EnableJpaRepositories(
	      entityManagerFactoryRef = "primaryEntityManager", transactionManagerRef = "primaryTransactionManager", basePackages = {
	      "com.ahtacode.playermarkt.repository"})
	  public static class RepositoryConfiguration {

	  }


}
