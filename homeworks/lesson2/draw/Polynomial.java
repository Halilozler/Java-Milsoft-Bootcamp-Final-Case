package Homework.draw;

public class Polynomial implements Function{
    private double[] coefficients;

    public Polynomial() {}

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public double evaluate(int x) {
        // y=a0+a1*x+a2*x^2+ a3*x^3 ...
        double result = 1;
        for(int i = 1; i < coefficients.length; i++){
            int squareX = 1;
            for(int j = 0; j < i; j++){
                squareX *= x;
            }
            result = coefficients[i] * squareX;
        }
        return result;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(double[] coefficients) {
        this.coefficients = coefficients;
    }
}
