package co.goho.qingxu.mybatistag.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class DataSourceConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Bean(name = DataSourceNames.FIRST)
    @Primary//  注意：这里需要该注解声明是默认数据源
    @ConfigurationProperties(prefix = "spring.datasource.druid.test")
    public DataSource testDateSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = DataSourceNames.SECOND)
    @ConfigurationProperties(prefix = "spring.datasource.druid.test1")
    public DataSource test1DateSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        // 配置多数据源
        Map<String, DataSource> dataBaseMap = new HashMap<>(16);
        dataBaseMap.put(DataSourceNames.FIRST, testDateSource());
        dataBaseMap.put(DataSourceNames.SECOND, test1DateSource());
        DynamicDataSource dynamicDataSource = new DynamicDataSource(testDateSource(),dataBaseMap);
        // 默认数据源
        return dynamicDataSource;
    }

    @Bean(name = "sqlServerSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources(mapperLocations));
        //配置mapper.xml文件路径
        return bean.getObject();
    }

    @Bean(name = "sqlServerTransactionManager")//事务管理@Transactional(TransactionManager="mysqlTransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("dynamicDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlServerSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlServerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
