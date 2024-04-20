package bobr.functions.logarithmic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static bobr.App.DELTA;
import static org.junit.Assert.*;

public class LnTest {

    Ln ln = new Ln();

    @ParameterizedTest
    @CsvFileSource(resources = "/ln.csv")
    public void lnTableTest(Double x, Double expected) {
        assertEquals(expected, ln.calc(x, DELTA));
    }
}