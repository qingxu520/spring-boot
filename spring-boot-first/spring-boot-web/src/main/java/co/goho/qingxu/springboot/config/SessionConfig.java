package co.goho.qingxu.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * session
 * maxInactiveIntervalInSeconds 默认是1800秒过期
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 120)
public class SessionConfig {
}
