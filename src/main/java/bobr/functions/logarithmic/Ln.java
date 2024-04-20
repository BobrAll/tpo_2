package bobr.functions.logarithmic;

import bobr.functions.FunctionWithAccuracy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ln implements FunctionWithAccuracy {

    private static final double DELTA = 1e-12;

    @Override
    public Double calc(Double x, Double accuracy) {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal step;
        int n = 1;

        if (x < 0)
            return Double.NaN;

        if (Math.abs(x - 0) < DELTA)
            return Double.NEGATIVE_INFINITY;

        do {
            step = makeStep(x, n);
            sum = sum.add(step);
            n++;
        } while (Math.abs(step.doubleValue()) >= accuracy);

        return 2 * sum.doubleValue();
    }

    private static BigDecimal makeStep(double x, int n) {
        final BigDecimal divisor = BigDecimal.valueOf(2L * n - 1);

        BigDecimal dividend = BigDecimal
                .valueOf(x - 1)
                .divide(BigDecimal.valueOf(x + 1), 10, RoundingMode.HALF_UP);

        dividend = dividend.pow(2 * n - 1);

        return dividend.divide(divisor, 10, RoundingMode.HALF_UP);
    }

}