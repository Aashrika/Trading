package com.assessment.trading.domain.strategies;

import com.assessment.trading.domain.Algo;
import org.springframework.stereotype.Service;

@Service
public class Signal3Strategy implements Strategy {

    private static final int STRATEGY_ID = 3;

    @Override
    public int getStrategyId() {
        return STRATEGY_ID;
    }

    @Override
    public void execute(Algo algo) {
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
    }
}