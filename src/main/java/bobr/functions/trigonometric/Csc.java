package bobr.functions.trigonometric;

import bobr.functions.FunctionWithAccuracy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Csc implements FunctionWithAccuracy {

    private final Sin sin;

    @Override
    public Double calc(Double x, Double delta) {
        return 1 / sin.calc(x, delta);
    }

}