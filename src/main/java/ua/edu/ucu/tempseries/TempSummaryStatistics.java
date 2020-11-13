package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double maxTemp;
    private double minTemp;

    public TempSummaryStatistics(double average, double deviation,
                                 double maximum, double minimum) {
        avgTemp = average;
        devTemp = deviation;
        maxTemp = maximum;
        minTemp = minimum;
    }
    public double[] summaryArray() {
        double[] summary = {avgTemp, devTemp, maxTemp, minTemp};
        return summary;
    }
}
