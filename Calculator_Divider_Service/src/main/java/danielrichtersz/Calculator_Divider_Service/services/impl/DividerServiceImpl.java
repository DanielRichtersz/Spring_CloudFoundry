package danielrichtersz.Calculator_Divider_Service.services.impl;

import danielrichtersz.Calculator_Divider_Service.services.interfaces.DividerService;
import org.springframework.stereotype.Service;

@Service
public class DividerServiceImpl implements DividerService {

    @Override
    public double calculate(double a, double b) {
        return a / b;
    }
}