package bobr.functions.trigonometric;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static bobr.AppTest.DELTA;
import static bobr.AppTest.funcMock;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CotTest {

    Sin sinMock = funcMock(Sin.class);
    Cos cosMock = funcMock(Cos.class);
    Cot cot = new Cot(sinMock, cosMock);

    @ParameterizedTest
    @CsvFileSource(resources = "/cot.csv")
    public void cotTableTest(Double x, Double expected) {
        assertEquals(expected, cot.calc(x, DELTA));
    }

}