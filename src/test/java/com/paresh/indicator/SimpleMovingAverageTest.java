package com.paresh.indicator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class SimpleMovingAverageTest {

    @Test
    public void tests() throws Exception {

        double[] series1 = new double[]{4, 5, 6};
        BigDecimal[] averages = SimpleMovingAverage.of(getArray(series1), 2);
        Assertions.assertTrue(averages[2].compareTo(BigDecimal.valueOf(5.25)) == 0);
        double[] series2 = new double[]{4, 5, 6, 7};
        averages = SimpleMovingAverage.of(getArray(series2), 2);
        Assertions.assertTrue(averages[3].compareTo(BigDecimal.valueOf(6.13)) == 0);

    }

    private BigDecimal[] getArray(double[] array) {
        BigDecimal[] response = new BigDecimal[array.length];
        for (int index = 0; index < array.length; index++) {
            response[index] = BigDecimal.valueOf(array[index]);
        }
        return response;
    }
}