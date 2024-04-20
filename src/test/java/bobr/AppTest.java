package bobr;


import bobr.functions.FunctionWithAccuracy;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static bobr.App.PATH_TO_TABLES;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTest {

    public static final double DELTA = 1e-9;

    public static <T extends FunctionWithAccuracy> T funcMock(Class<T> classToMock) {
        T funcMock = mock(classToMock);
        List<CSVRecord> records;

        try {
            records = CSVFormat
                    .DEFAULT
                    .parse(new FileReader(PATH_TO_TABLES + "/" + classToMock.getSimpleName().toLowerCase() + ".csv"))
                    .getRecords();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        records.forEach(
                record -> {
                    Double x = Double.parseDouble(record.get(0));
                    Double y = Double.parseDouble(record.get(1));

                    when(funcMock.calc(eq(x), anyDouble())).thenReturn(y);
                }
        );

        return funcMock;
    }

}
