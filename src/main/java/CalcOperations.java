import lombok.Getter;

@Getter
public class CalcOperations {
    private final double one;
    private final double two;

    public CalcOperations(double one, double two) {
        this.one = one;
        this.two = two;
    }

    public double add() {
        return one + two;
    }

    public double sub() {
        return one - two;
    }

    public double mult() {
        return one * two;
    }
    public double div() throws ArithmeticException{
        if (two == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return one / two;
    }

}
