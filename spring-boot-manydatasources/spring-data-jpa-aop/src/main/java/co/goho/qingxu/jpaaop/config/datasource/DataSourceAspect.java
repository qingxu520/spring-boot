package co.goho.qingxu.jpaaop.config.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源，切面处理类 处理带有注解的方法类
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(DataSource)")//注意：这里的xxxx代表的是上面public @interface DataSource这个注解DataSource的包名
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);
        if (ds == null) {
            DynamicDataSource.setDataBaseType(DataSourceNames.FIRST);
            logger.debug("set datasource is " + DataSourceNames.FIRST);
        } else {
            DynamicDataSource.setDataBaseType(ds.value());
            logger.debug("set datasource is " + ds.value());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataBaseType();
            logger.debug("clean datasource");
        }
    }



    @Override
    public int getOrder() {
        return 1;
    }
}
