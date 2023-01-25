public class Matematica {
    public double somma(double a, double b) {
        return a + b;
    }

    public double somma(double a, double b, double c) {
        return a + b + c;
    }

    public double sottrazione(double a, double b) {
        return a - b;
    }

    public double sottrazione(double a, double b, double c) {
        return a - b - c;
    }

    public double divisione(double a, double b) {
        return a / b;
    }

    public double radiceSomma(double a, double b) {
        return Math.sqrt(somma(a,b));
    }

    public double radiceSomma(double a, double b, double c) {
        return Math.sqrt(somma(a,b,c));
    }
}