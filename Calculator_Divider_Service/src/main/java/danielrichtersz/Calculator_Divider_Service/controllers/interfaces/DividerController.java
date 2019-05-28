package danielrichtersz.Calculator_Divider_Service.controllers.interfaces;

import org.springframework.http.ResponseEntity;

public interface DividerController {
    ResponseEntity calculate(String a, String b);
}
