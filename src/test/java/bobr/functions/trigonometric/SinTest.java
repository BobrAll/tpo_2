package bobr.functions.trigonometric;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static bobr.AppTest.DELTA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SinTest {

    Sin sin = new Sin();

    @ParameterizedTest
    @CsvFileSource(resources = "/sin.csv")
    public void sinTableTest(double x, double expected) {
        assertEquals(expected, sin.calc(x, DELTA));

        for (int coef = 0; coef < 200; coef += 2)
            assertTrue(Math.abs((expected - sin.calc(x + coef * Math.PI, DELTA))) < DELTA);
    }

}