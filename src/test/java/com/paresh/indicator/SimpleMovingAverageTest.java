package com.paresh.indicator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class SimpleMovingAverageTest {
    private SimpleMovingAverage simpleMovingAverage;

    @Test
    public void onlineExampleTest() throws Exception {

        double[] series = new double[]{1287.7, 1279.25, 1258.95, 1249.7, 1242.4, 1268.75, 1231.2, 1201.75, 1159.2, 1157.25, 1141.35, 1152.5, 1139.6, 1140.6, 1166.35, 1165.4, 1168.25};
        BigDecimal[] averages = SimpleMovingAverage.of(getArray(series), 5);

        for (BigDecimal value : averages) {
            System.out.println(value == null ? "NaN" : value.toPlainString());
        }

    }

    private BigDecimal[] getArray(double[] array) {
        BigDecimal[] response = new BigDecimal[array.length];
        for (int index = 0; index < array.length; index++) {
            response[index] = BigDecimal.valueOf(array[index]);
        }
        return response;
    }
}