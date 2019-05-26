package danielrichtersz.Calculator_App;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculatorAppApplication {

	public static String MICROSERVICE_ID;

	public static void main(String[] args) {
		SpringApplication.run(CalculatorAppApplication.class, args);
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
