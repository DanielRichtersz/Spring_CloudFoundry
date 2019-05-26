package danielrichtersz.Calculator_App.controllers.impls;

import danielrichtersz.Calculator_App.CalculatorAppApplication;
import danielrichtersz.Calculator_WebApp.controllers.interfaces.CalculatorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CalculatorControllerImpl implements CalculatorController {

    @GetMapping("{client}/hello")
    @Override
    public ResponseEntity helloWorld(
            @PathVariable(value = "client") String client) {
        if (CalculatorAppApplication.MICROSERVICE_ID != null) {
            return ResponseEntity.ok("Hello to " + client + " from micro service: " + CalculatorAppApplication.MICROSERVICE_ID);
        }
        return ResponseEntity.ok("Hello to " + client);
    }
}
