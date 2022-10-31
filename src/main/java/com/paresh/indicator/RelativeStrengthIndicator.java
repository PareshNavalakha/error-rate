package com.paresh.indicator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.paresh.util.NumberUtil.HUNDRED;

public class RelativeStrengthIndicator {

    public static BigDecimal[] of(BigDecimal[] values, int period) throws Exception {
        BigDecimal[] results = new BigDecimal[values.length];

        BigDecimal[] averageGainIndicator = ExponentialMovingAverage.of(Profits.of(values, period), period);
        BigDecimal[] averageLossIndicator = ExponentialMovingAverage.of(Losses.of(values, period), period);

        for (int index = 0; index < values.length; index++) {
            BigDecimal averageGain = averageGainIndicator[index];
            BigDecimal averageLoss = averageLossIndicator[index];
            if (averageLoss.compareTo(BigDecimal.ZERO) == 0) {
                if (averageGain.compareTo(BigDecimal.ZERO) == 0) {
                    results[index] = BigDecimal.ZERO;
                } else {
                    results[index] = HUNDRED;
                }
            } else {
                BigDecimal relativeStrength = averageGain.divide(averageLoss, 2, RoundingMode.HALF_UP);
                // compute relative strength index
                results[index] = HUNDRED.subtract((HUNDRED.divide((BigDecimal.ONE.add(relativeStrength)), 2, RoundingMode.HALF_UP)));
            }
        }

        return results;

    }

}
