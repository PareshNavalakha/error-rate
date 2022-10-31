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

        int maxLength = values.length - period;

        for (int index = 0; index < period; index++) {
            results[index] = BigDecimal.ZERO;
        }

        for (int index = 0; index < maxLength; index++) {
            results[index + period] = NumberUtil.average(values, RoundingMode.HALF_UP, index, period);
        }

        return results;
    }

}
