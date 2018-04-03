package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import repository.ILocalShopRepository;
import repository.IShopJpaRepository;
import repository.LocalShopRepository;


@Configuration
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("dao"),
    @ComponentScan("services")})
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
    public IShopJpaRepository getShopJpaRepository(){
        return  null;
    }


}
