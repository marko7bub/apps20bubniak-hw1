package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] tempSeries = {};
    private double minPossible = -273.0;
    private int lenSeries;
    public TemperatureSeriesAnalysis() {
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double value : temperatureSeries) {
            if (value < minPossible) {
                throw new InputMismatchException();
            }
        }
        lenSeries = temperatureSeries.length;
        tempSeries = temperatureSeries;
    }

    public double average() {
        if (lenSeries == 0) {
            throw new IllegalArgumentException();
        }
        double sumSeries = 0;
        for (double value : tempSeries) {
            sumSeries = sumSeries + value;
        }
        return sumSeries/lenSeries;
    }

    public double deviation() {
        if (lenSeries == 0) {
            throw new IllegalArgumentException();
        }
        double numerator = 0;
        double denominator = lenSeries;
        for (double value : tempSeries) {
            numerator = numerator + (value - average())*(value - average());
        }
        return Math.sqrt(numerator/denominator);
    }

    public double min() {
        if (lenSeries == 0) {
            throw new IllegalArgumentException();
        }
        double minSeries = tempSeries[0];
        for (double value : tempSeries) {
            if (value < minSeries) {
                minSeries = value;
            }
        }
        return minSeries;
    }

    public double max() {
        if (lenSeries == 0) {
            throw new IllegalArgumentException();
        }
        double maxSeries = tempSeries[0];
        for (double value:tempSeries) {
            if (value > maxSeries) {
                maxSeries = value;
            }
        }
        return maxSeries;
    }

    public double findTempClosestToZero() {
        if (lenSeries == 0) {
            throw new IllegalArgumentException();
        }
        return findTempClosestToValue(0.0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (lenSeries == 0) {
            throw new IllegalArgumentException();
        }
        double distSeries = Math.abs(tempSeries[0] - tempValue);
        double closestSeries = tempSeries[0];
        for (double value : tempSeries) {
            if (Math.abs(value - tempValue) < distSeries) {
                distSeries = Math.abs(value - tempValue);
                closestSeries = value;
            }
        }
        return closestSeries;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (lenSeries == 0) {
            throw new IllegalArgumentException();
        }
        int lesserNumber = 0;
        for (double value:tempSeries) {
            if (value < tempValue) {
                lesserNumber += 1;
            }
        }
        double[] lesserSeries = new double [lesserNumber];
        int lesserIndex = 0;
        for (double value : tempSeries) {
            if (value < tempValue) {
                lesserSeries[lesserIndex] = value;
                lesserIndex += 1;
            }
        }
        return lesserSeries;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (lenSeries == 0) {
            throw new IllegalArgumentException();
        }
        int greaterNumber = 0;
        for (double value : tempSeries) {
            if (value > tempValue) {
                greaterNumber += 1;
            }
        }
        double[] greaterSeries = new double [greaterNumber];
        int greaterIndex = 0;
        for (double value : tempSeries) {
            if (value > tempValue) {
                greaterSeries[greaterIndex] = value;
                greaterIndex += 1;
            }
        }
        return greaterSeries;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (lenSeries == 0) {
            throw new IllegalArgumentException();
        }
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public double addTemps(double... temps) {
        int expandedLength = lenSeries;
        while (expandedLength < lenSeries + temps.length) {
            expandedLength = expandedLength*2;
        }
        double[] expandedSeries = new double[expandedLength];
        int expandedIndex = 0;
        for (double value:tempSeries) {
            expandedSeries[expandedIndex] = value;
            expandedIndex = expandedIndex + 1;
        }
        for (double value : temps) {
            expandedSeries[expandedIndex] = value;
            expandedIndex = expandedIndex + 1;
        }
        double expandedSum = 0;
        for (double value:expandedSeries) {
            expandedSum = expandedSum + value;
        }
        return expandedSum;
    }
}
