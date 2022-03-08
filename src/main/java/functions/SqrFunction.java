package functions;

import static java.lang.Math.*;

public class SqrFunction implements MathFunction{
    @Override
    public double apply(double x) {
        return pow(x,2);
    }
}
