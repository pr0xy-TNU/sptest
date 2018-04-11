package com.sptest.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.sptest.server.repository.ILocalShopRepository;
import com.sptest.server.repository.LocalShopRepository;


@Configuration
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("com.sptest.server.dao"),
    @ComponentScan("com.sptest.server.services")})
public class AppConfig {

  @Bean
  public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
    LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
    factoryBean.setPersistenceUnitName("localPersistence");
    return factoryBean;
  }

  @Bean
  public JpaTransactionManager geJpaTransactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
    return transactionManager;
  }

  @Bean
  public ILocalShopRepository getShopRepository() {
    return new LocalShopRepository();
  }
}
