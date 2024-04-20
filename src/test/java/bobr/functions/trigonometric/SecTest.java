package bobr.functions.trigonometric;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static bobr.AppTest.DELTA;
import static bobr.AppTest.funcMock;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecTest {

    Cos cosMock = funcMock(Cos.class);
    Sec sec = new Sec(cosMock);

    @ParameterizedTest
    @CsvFileSource(resources = "/sec.csv")
    public void secTableTest(Double x, Double expected) {
        assertEquals(expected, sec.calc(x, DELTA));
    }

}