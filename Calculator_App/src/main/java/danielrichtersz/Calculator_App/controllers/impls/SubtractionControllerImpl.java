package danielrichtersz.Calculator_App.controllers.impls;

import danielrichtersz.Calculator_App.CalculatorAppApplication;
import danielrichtersz.Calculator_App.controllers.interfaces.CalculatorController;
import danielrichtersz.Calculator_App.services.interfaces.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class SubtractionControllerImpl implements CalculatorController {

    @Autowired
    public ParsingService parsingService;

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
            @RequestParam(value = "sumString") String sumString) {
        String answer = this.parsingService.saveSum(sumString);
        if (answer != null) {
            //Success


            return ResponseEntity.status(HttpStatus.OK).body("Answer: " + answer);
        }
        //Failure
        return ResponseEntity.status(HttpStatus.OK).body("Sum could not be parsed, please check for invalid characters");
    }
}
