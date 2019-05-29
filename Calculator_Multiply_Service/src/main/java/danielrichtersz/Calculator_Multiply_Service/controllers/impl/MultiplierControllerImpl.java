package danielrichtersz.Calculator_Multiply_Service.controllers.impl;

import danielrichtersz.Calculator_Multiply_Service.controllers.interfaces.MultiplierController;
import danielrichtersz.Calculator_Multiply_Service.services.interfaces.MultiplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MultiplierControllerImpl implements MultiplierController {

    @Autowired
    private MultiplierService multiplierService;

    @GetMapping("/calculate/{a}/{b}")
    @Override
    public ResponseEntity calculate(
            @PathVariable(value = "a") String a,
            @PathVariable(value = "b") String b) {

        double dA;
        double dB;

        try {
            dA = Double.parseDouble(a);
            dB = Double.parseDouble(b);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Path parameters did not match doubles. " +
                    "For decimals, please use this a 'dot' as divider and not a 'comma'. " +
                    "Example: 3.14");
        }

        double result = this.multiplierService.calculate(dA, dB);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
