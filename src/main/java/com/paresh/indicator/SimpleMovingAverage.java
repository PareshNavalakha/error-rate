package com.paresh.indicator;


import com.paresh.util.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleMovingAverage {


    public static BigDecimal[] of(BigDecimal[] values, int period) {

        if (values.length < period)
            throw new IllegalArgumentException("Not enough data points, given data size less then the indicated period");

        BigDecimal[] results = new BigDecimal[values.length];

        for (int index = 0; index < (period - 1); index++) {
            results[index] = BigDecimal.ZERO;
        }

        for (int index = (period - 1); index < values.length; index++) {
            if (index == (period - 1)) {
                results[index] = NumberUtil.average(values, RoundingMode.HALF_UP, 0, period);
            } else {
                results[index] = ((results[index - 1].multiply(BigDecimal.valueOf((period - 1)))).add(values[index])).divide(BigDecimal.valueOf(period), 4, RoundingMode.HALF_UP);
            }
        }

        return results;
    }

}
