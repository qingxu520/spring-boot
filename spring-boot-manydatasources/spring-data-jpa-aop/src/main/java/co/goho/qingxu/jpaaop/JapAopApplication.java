package co.goho.qingxu.jpaaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JapAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JapAopApplication.class, args);
	}

}
