package danielrichtersz.Calculator_App.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculatorController {
    ResponseEntity helloWorld(String client);

    ResponseEntity calculate(String sumString);
}
