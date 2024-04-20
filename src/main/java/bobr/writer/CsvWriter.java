package bobr.writer;

import bobr.functions.FunctionWithAccuracy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CsvWriter {

    private double start = 0;
    private double finish = 0;
    private double step = 0;
    private double delta = 1;

    public void write(FunctionWithAccuracy function, File destination) throws IOException {
        List<Double[]> numPair = new ArrayList<>();

        for (double i = start; i <= finish; i += step)
            numPair.add(new Double[]{i, function.calc(i, delta)});

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(destination)))) {
            for (Double[] tuple : numPair)
                writer.printf("%s, %s\n", tuple[0].toString(), tuple[1].toString());
        }
    }

}
