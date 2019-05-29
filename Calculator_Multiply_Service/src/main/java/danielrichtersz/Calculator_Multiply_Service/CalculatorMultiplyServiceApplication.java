package danielrichtersz.Calculator_Multiply_Service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculatorMultiplyServiceApplication {

	public static String MICROSERVICE_ID;

	public static void main(String[] args) {
		SpringApplication.run(CalculatorMultiplyServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args -> {
			if (args.length > 0) {
				this.MICROSERVICE_ID = args[0];
			}
		});
	}
}
