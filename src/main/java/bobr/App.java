package bobr;

import bobr.functions.custom.CustomFunc;
import bobr.functions.logarithmic.Ln;
import bobr.functions.logarithmic.Log10;
import bobr.functions.logarithmic.Log5;
import bobr.functions.trigonometric.*;
import bobr.writer.CsvWriter;

import java.io.File;
import java.io.IOException;

public class App {

    public static final String PATH_TO_TABLES = "src/test/resources";
    public static final double DELTA = 1e-12;

    private static final Ln ln = new Ln();
    private static final Log5 log5 = new Log5(ln);
    private static final Log10 log10 = new Log10(ln);

    private static final Sin sin = new Sin();
    private static final Cos cos = new Cos(sin);
    private static final Sec sec = new Sec(cos);
    private static final Csc csc = new Csc(sin);
    private static final Cot cot = new Cot(sin, cos);

    private static final CustomFunc customFunc = new CustomFunc(ln, log5, log10, sin, cos, sec, csc, cot);

    public static void main(String[] args) throws IOException {
        CsvWriter writer = CsvWriter.builder()
                .start(-10)
                .finish(10)
                .step(0.01)
                .delta(DELTA)
                .build();

        writer.write(customFunc, new File("src/main/resources/result.csv"));
    }

}
