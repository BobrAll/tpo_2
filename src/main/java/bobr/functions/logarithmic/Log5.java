package bobr.functions.logarithmic;

import bobr.functions.FunctionWithAccuracy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Log5 implements FunctionWithAccuracy {

    private final Ln ln;

    @Override
    public Double calc(Double x, Double accuracy) {
        return ln.calc(x, accuracy) / ln.calc(5d, accuracy);
    }

}
