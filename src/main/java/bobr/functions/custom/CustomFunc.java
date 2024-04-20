package bobr.functions.custom;

import bobr.functions.FunctionWithAccuracy;
import bobr.functions.logarithmic.Ln;
import bobr.functions.logarithmic.Log10;
import bobr.functions.logarithmic.Log5;
import bobr.functions.trigonometric.*;
import lombok.RequiredArgsConstructor;

import static bobr.App.DELTA;

@RequiredArgsConstructor
public class CustomFunc implements FunctionWithAccuracy {

    private final Ln ln;
    private final Log5 log5;
    private final Log10 log10;

    private final Sin sin;
    private final Cos cos;
    private final Sec sec;
    private final Csc csc;
    private final Cot cot;

    @Override
    public Double calc(Double x, Double accuracy) {
        if (x <= 0) {
            Double part1Numerator = (cos.calc(x, DELTA) / sin.calc(x, DELTA)) * sin.calc(x, DELTA);
            Double part1Denominator = part1Numerator / (sin.calc(x, DELTA) - sec.calc(x, DELTA));
            Double part1 = part1Numerator / part1Denominator;

            Double part2 = csc.calc(x, DELTA) * sin.calc(x, DELTA);
            Double part3 = cot.calc(x, DELTA);

            return ((part1 + part2) + part3);
        } else {
            Double part1Numerator = (((log5.calc(x, DELTA) + log5.calc(x, DELTA)) - ln.calc(x, DELTA)) - log5.calc(x, DELTA));
            Double part1Denominator = log10.calc(x, DELTA);
            Double part1 = part1Numerator / part1Denominator;

            Double part2 = Math.pow(log5.calc(x, DELTA), 2);

            return part1 - part2;
        }
    }

}
