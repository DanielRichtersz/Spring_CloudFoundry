package danielrichtersz.Calculator_Divider_Service.controllers.impl;

import danielrichtersz.Calculator_Divider_Service.controllers.interfaces.DividerController;
import danielrichtersz.Calculator_Divider_Service.services.interfaces.DividerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class DividerControllerImpl implements DividerController {

    @Autowired
    private DividerService dividerService;

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
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Path paramters did not match doubles. " +
                    "For decimals, please use this a 'dot' as divider and not a 'comma'. " +
                    "Example: 3.14");
        }

        double result = this.dividerService.calculate(dA, dB);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}