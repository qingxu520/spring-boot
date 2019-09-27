package co.goho.qingxu.springboot.config;

/*import co.goho.qingxu.springboot.dao.UserRepository;
import co.goho.qingxu.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;*/

/**
 * 路由器 Web Flux
 *
 * Reactive：分发请求（路由）异步非阻塞处理机制  ---Web Flux
 * 适用Netty
 * 和传统集合对象基本同步处理（阻塞）相比，运行更流畅，提高吞吐量  ---Web MVC
 */
//@Configuration
public class RouterFunctionConfiguration {

    /**
     * 在Servlet中
     * 请求接口：ServletRequest 或者 HtpServletRequest
     * 响应接口：ServletResponse 或者 HttpServletResponse
     *
     * Spring 5.0重新定义了服务请求和响应接口：
     * 请求接口：ServerRequest
     * 响应接口：ServerResponse
     * 既支持Servlet规范 也支持自定义
     * Flux 是0~N个对象结合
     * Mono 是0~1个对象集合
     * Flux 或者 Mono 都是PubLisher
     * Reactive中的Flux或者Mono 它是异步处理（非阻塞）
     * 集合对象基本上是同步处理（阻塞）
     **/
    /*@Bean
    @Autowired
    public RouterFunction<ServerResponse> findAllUser(UserRepository userRepository) {
        return RouterFunctions.route(RequestPredicates.GET("/user/findall"),
                Request -> {
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
                }
        );

    }*/
}
