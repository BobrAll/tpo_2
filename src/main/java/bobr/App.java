package bobr;

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

    public static void main(String[] args) throws IOException {
        CsvWriter writer = CsvWriter.builder()
                .start(0)
                .finish(500)
                .step(50)
                .delta(DELTA)
                .build();

//        writer.write(sin, new File( PATH_TO_TABLES + "/sin.csv"));
//        writer.write(cos, new File(PATH_TO_TABLES + "/cos.csv"));
//        writer.write(sec, new File(PATH_TO_TABLES + "/sec.csv"));
//        writer.write(csc, new File(PATH_TO_TABLES + "/csc.csv"));
//        writer.write(cot, new File(PATH_TO_TABLES + "/cot.csv"));
//        writer.write(ln, new File(PATH_TO_TABLES + "/ln.csv"));
//        writer.write(log5, new File(PATH_TO_TABLES + "/log5.csv"));
//        writer.write(log10, new File(PATH_TO_TABLES + "/log10.csv"));
//        System.out.println(ln.calc(5d, DELTA));
//        System.out.println(ln.calc(10d, DELTA));
    }

}
