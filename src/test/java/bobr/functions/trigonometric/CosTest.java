package bobr.functions.trigonometric;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static bobr.AppTest.DELTA;
import static bobr.AppTest.funcMock;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {

    Sin sinMock = funcMock(Sin.class);
    Cos cos = new Cos(sinMock);

    @ParameterizedTest
    @CsvFileSource(resources = "/cos.csv")
    public void cosTableTest(Double x, Double expected) {
        assertEquals(expected, cos.calc(x, DELTA));
    }

}