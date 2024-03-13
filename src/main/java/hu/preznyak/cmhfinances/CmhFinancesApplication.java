package hu.preznyak.cmhfinances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CmhFinancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmhFinancesApplication.class, args);
	}

}
