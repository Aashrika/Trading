package com.assessment.trading.domain.strategies;

import com.assessment.trading.domain.Algo;
import com.assessment.trading.domain.Strategy;
import org.springframework.stereotype.Service;

@Service
public class Signal1Strategy implements Strategy {
  private static final int STRATEGY_ID = 1;

  @Override
  public int getStrategyId() {
    return STRATEGY_ID;
  }

  @Override
  public void execute(Algo algo) {
    algo.setUp();
    algo.setAlgoParam(1, 60);
    algo.performCalc();
    algo.submitToMarket();
  }
}
