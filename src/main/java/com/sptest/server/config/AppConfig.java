package com.sptest.server.config;

import com.mongodb.MongoClient;
import com.sptest.server.repository.ILocalShopRepository;
import com.sptest.server.repository.LocalShopRepository;
import com.sptest.server.utils.DBConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
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

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongoClient = new MongoClient(DBConstants.MONGO_LOCAL_HOST,
            DBConstants.MONGO_LOCAL_PORT);
        UserCredentials userCredentials = new UserCredentials(DBConstants.MONGO_LOCAL_USER,
            DBConstants.MONGO_LOCAL_PASSWORD);
        return new SimpleMongoDbFactory(mongoClient, DBConstants.MONGO_DATABASE_NAME,
            userCredentials);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
