package com.assessment.trading.domain.strategies;

import com.assessment.trading.domain.Algo;
import com.assessment.trading.domain.SignalStrategy;
import org.springframework.stereotype.Service;

@Service
public class DefaultSignalStrategy implements SignalStrategy {
    @Override
    public void execute(Algo algo) {
        algo.cancelTrades();
    }
}