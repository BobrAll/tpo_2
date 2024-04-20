package bobr.functions.trigonometric;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static bobr.AppTest.DELTA;
import static bobr.AppTest.funcMock;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CscTest {

    Sin sinMock = funcMock(Sin.class);
    Csc csc = new Csc(sinMock);

    @ParameterizedTest
    @CsvFileSource(resources = "/csc.csv")
    public void cscTableTest(Double x, Double expected) {
        assertEquals(expected, csc.calc(x, DELTA));
    }

}