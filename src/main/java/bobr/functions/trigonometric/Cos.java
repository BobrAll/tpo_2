package bobr.functions.trigonometric;

import bobr.functions.FunctionWithAccuracy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cos implements FunctionWithAccuracy {

    private final Sin sin;

    @Override
    public Double calc(Double x, Double accuracy) {
        return sin.calc(Math.PI / 2 - x, accuracy);
    }

}
