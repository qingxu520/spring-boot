package co.goho.qingxu.springboot.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * filter
 */
@Configuration
public class WebConfiguration {

    /**
     * Spring Boot、Spring Web和Spring MVC等其他框架，
     * 都提供了很多servlet 过滤器可使用，我们需要在配置文件中定义这些过滤器为bean对象。
     * 现在假设我们的应用程序运行在一台负载均衡代理服务器后方，
     * 因此需要将代理服务器发来的请求包含的IP地址转换成真正的用户IP。
     * Tomcat 8 提供了对应的过滤器：RemoteIpFilter。通过将RemoteFilter这个过滤器加入过滤器调用链即可使用它。
     * @return
     */
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 实现了javax.servlet.Filter接口的服务器端程序，主要的用途是过滤字符编码、做一些业务逻辑判断等。
     * 其工作原理是，只要你在web.xml文件配置好要拦截的客户端请求，它都会帮你拦截到请求，
     * 此时你就可以对请求或响应(Request、Response)统一设置编码，简化操作；同时还可进行逻辑判断，
     * 如用户是否已经登陆、有没有权限访问该页面等等工作。它是随你的web应用启动而启动的，只初始化一次，
     * 以后就可以拦截相关请求，只有当你的web应用停止或重新部署的时候才销毁
     *
     * servlet，filter，listener的作用和原理 原文链接：https://blog.csdn.net/h2604396739/article/details/84899251
     */
    public class MyFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("this is MyFilter,url:"+request.getRequestURI());
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {

        }
    }

}
