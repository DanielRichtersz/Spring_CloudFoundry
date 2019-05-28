package danielrichtersz.Calculator_App.models.calculations;

public class MultiplyCalculation implements Calculation {

    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}
