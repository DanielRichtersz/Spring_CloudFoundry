package danielrichtersz.Calculator_Multiply_Service.services.impl;

import danielrichtersz.Calculator_Multiply_Service.services.interfaces.MultiplierService;
import org.springframework.stereotype.Service;

@Service
public class MultiplierServiceImpl implements MultiplierService {

    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}
