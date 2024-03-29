package co.goho.qingxu.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "test1ManagerFactory",//配置连接工厂 entityManagerFactory
        transactionManagerRef = "test1TransactionManager", //配置 事物管理器  transactionManager
        basePackages = {"co.goho.qingxu.jpa.dao.test1"}
)
public class DataSource1Config {
    //jpa其他参数配置
    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;

    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("test1ManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(@Qualifier("test1DataSource")DataSource dataSource,EntityManagerFactoryBuilder builder) {
            Map<String,Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),new HibernateSettings());
        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("co.goho.qingxu.jpa")
                //持久化单元名称，当存在多个EntityManagerFactory时，需要制定此名称
                .persistenceUnit("test1PersistenceUnit")
                .build();
    }

    /**
     * EntityManager不过解释，用过jpa的应该都了解
     * @return
     */
    @Bean(name = "test1EntityManager")
    public EntityManager entityManager(@Qualifier("test1DataSource")DataSource dataSource,EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryBean(dataSource,builder).getObject().createEntityManager();
    }
    @Bean("test1TransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("test1DataSource")DataSource dataSource,EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryBean(dataSource,builder).getObject());
    }
}
