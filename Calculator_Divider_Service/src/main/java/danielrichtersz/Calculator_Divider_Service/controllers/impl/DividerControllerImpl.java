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
            @PathVariable(value = "a") double a,
            @PathVariable(value = "b") double b) {
        double result = this.dividerService.calculate(a, b);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}