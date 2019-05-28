package danielrichtersz.Calculator_App.services.impl;

import danielrichtersz.Calculator_App.models.calculations.Calculation;
import danielrichtersz.Calculator_App.models.calculations.DivideCalculation;
import danielrichtersz.Calculator_App.models.calculations.MultiplyCalculation;
import danielrichtersz.Calculator_App.services.interfaces.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    Map<String, Calculation> calculationMap = new HashMap<String, Calculation>() {{
       put("*", new MultiplyCalculation());
       put("/", new DivideCalculation());
    }};

    public double calculate(String calculation) {

        String type = this.getTypeOfCalculation(calculation);
        return this.tryCalculation(calculation, type);
    }

    private String getTypeOfCalculation(String calculation) {
        String tempType = calculation.replaceAll("[^*/]", "");

        if (tempType.length() > 1) {
            //Contains multiple calculation symbols, we only do 1
            return null;
        }

        return tempType;
    }

    private double tryCalculation(String calculation, String type) {
        String tempCalc = calculation.replaceAll("[^0-9" + type +"]", "");
        try {

            double a = Double.parseDouble(tempCalc.substring(0, tempCalc.indexOf(type)));
            double b = Double.parseDouble(tempCalc.substring(tempCalc.indexOf(type) + 1));

            return this.calculationMap.get(type).calculate(a, b);
        }
        catch (Exception e) {
            throw e;
        }
    }
}