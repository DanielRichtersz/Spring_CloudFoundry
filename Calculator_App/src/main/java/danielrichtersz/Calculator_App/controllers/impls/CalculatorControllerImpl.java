package danielrichtersz.Calculator_App.controllers.impls;

import danielrichtersz.Calculator_App.CalculatorAppApplication;
import danielrichtersz.Calculator_App.controllers.interfaces.CalculatorController;
import danielrichtersz.Calculator_App.services.interfaces.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class CalculatorControllerImpl implements CalculatorController {

    @Autowired
    public CalculatorService calculatorService;

    @GetMapping("{client}/hello")
    @Override
    public ResponseEntity helloWorld(
            @PathVariable(value = "client") String client) {
        if (CalculatorAppApplication.MICROSERVICE_ID != null) {
            return ResponseEntity.ok("Hello to " + client + " from micro service: " + CalculatorAppApplication.MICROSERVICE_ID);
        }
        return ResponseEntity.ok("Hello to " + client);
    }

    @PostMapping("/calculate")
    @Override
    public ResponseEntity calculate(
            @RequestParam(value = "calculation") String calculation) {
        double result = this.calculatorService.calculate(calculation);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
