package co.goho.qingxu.mybatistag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MybatisAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisAopApplication.class, args);
	}

}
