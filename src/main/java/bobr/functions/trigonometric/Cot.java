package bobr.functions.trigonometric;

import bobr.functions.FunctionWithAccuracy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cot implements FunctionWithAccuracy {

    private final Sin sin;
    private final Cos cos;

    @Override
    public Double calc(Double x, Double accuracy) {
        return cos.calc(x, accuracy) / sin.calc(x, accuracy);
    }

}
