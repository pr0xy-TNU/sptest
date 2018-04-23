package com.sptest.server.config;

import com.mongodb.MongoClient;
import com.sptest.server.repository.ILocalShopRepository;
import com.sptest.server.repository.LocalShopRepository;
import com.sptest.server.utils.DBConstants;
import java.net.UnknownHostException;
import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScans(
    value = {
        @ComponentScan("com.sptest.server.dao"),
        @ComponentScan("com.sptest.server.services"),
        @ComponentScan("com.sptest.server")
    })
@PropertySource("classpath:local.properties")
public class AppConfig {

  @Value("${mysql.db.password}")
  private String mysqlDatabasePassword;

  @Value("${mysql.db.username}")
  private String mysqlDatabaseUser;

  @Value("${db.host}")
  private String databaseHost;

  @Value("${mongo.db.port}")
  private Integer mongoPort;

  @Value("${mongo.db.database.name}")
  private String mongoDbName;

  @Value("${mongo.db.username}")
  private String mongoUserName;

  @Value("${mongo.db.password}")
  private String mongoUserPassword;

  @Value("${jpa.local.confg.profile}")
  private String jpaLocalProfile;

  @Value("${mysql.db.driver}")
  private String mysqlDatabaseDriver;

  @Value("${mysql.db.url}")
  private String mysqlDatabaseUrl;

  @Autowired
  private Environment env;

  @Bean
  public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
    LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
    factoryBean.setPersistenceUnitName(jpaLocalProfile);
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

  @Bean
  public MongoDbFactory mongoDbFactory() throws Exception {
    MongoClient mongoClient = new MongoClient(databaseHost, mongoPort);
    UserCredentials userCredentials = new UserCredentials(mongoUserName, mongoUserPassword);
    return new SimpleMongoDbFactory(mongoClient, mongoDbName, userCredentials);
  }

  @Bean
  public MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongoDbFactory());
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(mysqlDatabaseDriver);
    dataSource.setUrl(mysqlDatabaseUrl);
    dataSource.setUsername(mysqlDatabaseUser);
    dataSource.setPassword(mysqlDatabasePassword);
    return dataSource;
  }

  /*@Bean
  public SpringLiquibase liquibase() {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setChangeLog("classpath:liquibase-changelog.xml");
    liquibase.setDataSource(dataSource());
    return liquibase;
  }*/


}
