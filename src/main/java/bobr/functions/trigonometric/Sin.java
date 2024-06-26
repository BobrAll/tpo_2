package bobr.functions.trigonometric;

import bobr.functions.FunctionWithAccuracy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sin implements FunctionWithAccuracy {

    @Override
    public Double calc(Double x, Double accuracy) {
        double sum = 0d;
        double step;
        int n = 0;

        x %= 2 * Math.PI;

        do {
            step = makeStep(x, n);
            sum += step;
            n++;
        } while (Math.abs(step) >= accuracy);

        return sum;
    }

    private static Double makeStep(Double x, int n) {
        BigDecimal divisor = factorial(2 * n + 1);
        BigDecimal dividend = BigDecimal.valueOf(x).pow(2 * n + 1);

        if (n % 2 != 0)
            dividend = dividend.negate();

        return dividend.divide(divisor, 10, RoundingMode.HALF_UP).doubleValue();
    }

    private static BigDecimal factorial(int x) {
        BigDecimal p = BigDecimal.ONE;

        for (int i = 1; i <= x; i++)
            p = p.multiply(BigDecimal.valueOf(i));

        return p;
    }

}
