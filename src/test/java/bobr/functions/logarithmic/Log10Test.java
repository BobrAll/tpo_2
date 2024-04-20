package bobr.functions.logarithmic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static bobr.App.DELTA;
import static bobr.AppTest.funcMock;
import static org.junit.Assert.assertEquals;

public class Log10Test {

    Ln lnMock = funcMock(Ln.class);
    Log10 log10 = new Log10(lnMock);

    @ParameterizedTest
    @CsvFileSource(resources = "/log10.csv")
    public void log10TableTest(Double x, Double expected) {
        assertEquals(expected, log10.calc(x, DELTA));
    }

}