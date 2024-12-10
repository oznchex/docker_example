package liaison.linkit_db_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LinkitDbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkitDbTestApplication.class, args);
	}

}
