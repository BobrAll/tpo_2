package bobr.graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphPlotter extends JFrame {

    public GraphPlotter(String title) {
        super(title);

        XYSeries series = new XYSeries("Data");

        try (BufferedReader br = new BufferedReader(new FileReader("result"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                double x = Double.parseDouble(parts[0].trim());
                double y = Double.parseDouble(parts[1].trim());

                series.add(x, y);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Graph Plot",
                "X",
                "Y",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphPlotter plotter = new GraphPlotter("Graph Plotter");
            plotter.pack();
            plotter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            plotter.setVisible(true);
        });
    }
}
