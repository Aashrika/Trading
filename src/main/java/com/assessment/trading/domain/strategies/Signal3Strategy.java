package com.assessment.trading.domain.strategies;

import com.assessment.trading.domain.Algo;
import com.assessment.trading.domain.SignalStrategy;
import org.springframework.stereotype.Service;

@Service
public class Signal3Strategy implements SignalStrategy {
    @Override
    public void execute(Algo algo) {
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
    }
}