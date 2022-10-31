package com.paresh.indicator;


import com.paresh.util.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleMovingAverage {


    public static BigDecimal[] of(BigDecimal[] values, int period) {
        BigDecimal[] results;
        if (values.length < period)
            throw new IllegalArgumentException("Not enough data points, given data size less then the indicated period");

        results = new BigDecimal[values.length];

        for (int index = 0; index < period; index++) {
            results[index] = BigDecimal.ZERO;
        }

        for (int index = period; index < values.length; index++) {
            if (index == period) {
                results[index] = NumberUtil.average(values, RoundingMode.HALF_UP, index - period, period);
            } else {
                results[index] = ((results[index - 1].multiply(BigDecimal.valueOf((period - 1)))).add(values[index])).divide(BigDecimal.valueOf(period), 2, RoundingMode.HALF_UP);
            }
        }

        return results;
    }

}
