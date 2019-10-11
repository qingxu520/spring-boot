package co.goho.qingxu.easy.config.datasource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 数据源设置类
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private Logger logger = LogManager.getLogger("UserController");
    /**
     * 线程独立
     */
    private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();


    public DynamicDataSource(DataSource defaultTargetDataSource, Map<String, DataSource> targetDataSources) {
        // 默认数据源
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(new HashMap<Object, Object>(targetDataSources));
        super.afterPropertiesSet();
    }
    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("当前数据源：{}" + getDataBaseType());
        return getDataBaseType();
    }

    public static String getDataBaseType() {
        return contextHolder.get();
    }

    public static void setDataBaseType(String dataBase) {
        contextHolder.set(dataBase);
    }

    public static void clearDataBaseType() {
        contextHolder.remove();
    }
}