package com.paresh.indicator;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class RelativeStrengthIndicatorTest {

    private RelativeStrengthIndicator relativeStrengthIndicator;

    @Test
    public void onlineExampleTest() throws Exception {

        double[] series = new double[]{44.34, 44.09, 44.15, 43.61, 44.33, 44.83, 45.10, 45.42, 45.84, 46.08, 45.89, 46.03, 45.61, 46.28, 46.28, 46.00, 46.03, 46.41, 46.22, 45.64, 46.21, 46.25, 45.71, 46.45, 45.78, 45.35, 44.03, 44.18, 44.22, 44.57, 43.42, 42.66, 43.13};
        BigDecimal[] array = RelativeStrengthIndicator.of(getArray(series), 14);

        for (BigDecimal value : array) {
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