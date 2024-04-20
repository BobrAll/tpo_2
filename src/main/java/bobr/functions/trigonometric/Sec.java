package bobr.functions.trigonometric;

import bobr.functions.FunctionWithAccuracy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Sec implements FunctionWithAccuracy {

    private final Cos cos;

    @Override
    public Double calc(Double x, Double accuracy) {
        Double cosVal = cos.calc(x, accuracy);

        if (Double.isNaN(cosVal) || cosVal == 0)
            return Double.NaN;

        return 1 / cosVal;
    }

}
