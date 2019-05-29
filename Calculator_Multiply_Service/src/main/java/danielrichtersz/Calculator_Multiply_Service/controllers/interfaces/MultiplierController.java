package danielrichtersz.Calculator_Multiply_Service.controllers.interfaces;

import org.springframework.http.ResponseEntity;

public interface MultiplierController {
    ResponseEntity calculate(String a, String b);
}
