package co.goho.qingxu.shiro.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class DataSourceConfig {

    @Bean(name = DataSourceNames.FIRST)
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
    @Primary//  注意：这里需要该注解声明是默认数据源
    public DataSource dynamicDataSource() {
        // 配置多数据源
        Map<String, DataSource> dataBaseMap = new HashMap<>();
        dataBaseMap.put(DataSourceNames.FIRST, testDateSource());
        dataBaseMap.put(DataSourceNames.SECOND, test1DateSource());
        DynamicDataSource dynamicDataSource = new DynamicDataSource(testDateSource(),dataBaseMap);
        // 默认数据源
        return dynamicDataSource;
    }
}
