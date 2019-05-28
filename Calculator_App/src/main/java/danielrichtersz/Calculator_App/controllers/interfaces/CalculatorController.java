package danielrichtersz.Calculator_App.controllers.interfaces;

import org.springframework.http.ResponseEntity;

public interface CalculatorController {
    ResponseEntity helloWorld(String client);

    ResponseEntity calculate(String sumString);
}
