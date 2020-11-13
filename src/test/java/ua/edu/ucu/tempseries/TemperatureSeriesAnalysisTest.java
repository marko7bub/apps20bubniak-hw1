package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void averageTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, 5.0, 3.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 33.2;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void deviationTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, 5.0, 3.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 45.31207;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void minTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, -5.0, 3.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void maxTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, 5.0, 3.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 120.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void closesttozeroTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, 5.0, 3.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void closesttovalueTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, 5.0, 3.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 120.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(119.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void lessTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, 5.0, 3.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {1.0, 36.6, 5.0, 3.4};
        double[] actualResult = seriesAnalysis.findTempsLessThen(37.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void greaterTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, 5.0, 3.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {36.6, 120.0, 5.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(4.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void addTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, 5.0, 3.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 195.0;
        double[] added = {6.0, 3.0, 23.0, -3.0};
        double actualResult = seriesAnalysis.addTemps(added);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void summaryTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, 5.0, 3.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {33.2, 45.31207, 1.0, 120.0};
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
        assertArrayEquals(expResult, actualResult.summaryArray(), 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void toolowTest(){
        double[] temperatureSeries = {1.0, 36.6, 120.0, 5.0, 3.4, -300.00};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyTest(){
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }
}
