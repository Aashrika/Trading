package com.assessment.trading.domain.strategies;

import com.assessment.trading.domain.Algo;
import org.springframework.stereotype.Service;

@Service
public class Signal2Strategy implements Strategy {

  private static final int STRATEGY_ID = 2;

  @Override
  public int getStrategyId() {
    return STRATEGY_ID;
  }

  @Override
  public void execute(Algo algo) {
    algo.reverse();
    algo.setAlgoParam(1, 80);
    algo.submitToMarket();
  }
}
