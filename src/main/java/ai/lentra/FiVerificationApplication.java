package ai.lentra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
public class FiVerificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiVerificationApplication.class, args);
	}

}
