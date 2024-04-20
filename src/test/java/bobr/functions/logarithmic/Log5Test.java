package bobr.functions.logarithmic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static bobr.App.DELTA;
import static bobr.AppTest.funcMock;
import static org.junit.Assert.*;

public class Log5Test {

    Ln lnMock = funcMock(Ln.class);
    Log5 log5 = new Log5(lnMock);

    @ParameterizedTest
    @CsvFileSource(resources = "/log5.csv")
    public void log5TableTest(Double x, Double expected) {
        assertEquals(expected, log5.calc(x, DELTA));
    }

}