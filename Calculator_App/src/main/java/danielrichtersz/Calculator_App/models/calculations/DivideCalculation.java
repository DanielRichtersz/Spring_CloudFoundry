package danielrichtersz.Calculator_App.models.calculations;

public class DivideCalculation implements Calculation {

    @Override
    public double calculate(double a, double b) {
        return a / b;
    }
}
