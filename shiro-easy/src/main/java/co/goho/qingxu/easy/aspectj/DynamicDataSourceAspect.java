package co.goho.qingxu.easy.aspectj;

import co.goho.qingxu.easy.config.datasource.DynamicDataSource;
import co.goho.qingxu.easy.conmmon.annotation.DataSource;
import co.goho.qingxu.easy.conmmon.constant.DataSourceNames;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description: 动态切换数据源类
*/
@Aspect
@Component
@Order(-10)
public class DynamicDataSourceAspect {
    private Logger logger =  LogManager.getLogger("DynamicDataSourceAspect");

    @Before("@annotation(co.goho.qingxu.easy.conmmon.annotation.DataSource)")
    public void beforeSwitchDS(JoinPoint point){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DataSourceNames.FIRST;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(DataSource.class)) {
                DataSource annotation = method.getAnnotation(DataSource.class);
                if (annotation == null) {
                    dataSource = DataSourceNames.FIRST;
                } else {
                    dataSource = annotation.value();
                }
            }
        } catch (Exception e) {
            logger.error("=======> 切换数据源失败："+e.getMessage());
            e.printStackTrace();
        }
        // 切换数据源
        logger.info("=======> 切换数据源成功："+dataSource);
        DynamicDataSource.setDataBaseType(dataSource);
    }

    @After("@annotation(co.goho.qingxu.easy.conmmon.annotation.DataSource)")
    public void afterSwitchDS(JoinPoint point){
        DynamicDataSource.clearDataBaseType();
    }


}
