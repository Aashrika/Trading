package com.assessment.trading.domain.strategies;

import com.assessment.trading.domain.Algo;
import com.assessment.trading.domain.Strategy;
import org.springframework.stereotype.Service;

@Service
public class DefaultSignalStrategy implements Strategy {

    @Override
    public int getStrategyId() {
        return 0;
    }

    @Override
    public void execute(Algo algo) {
        algo.cancelTrades();
    }
}