package com.assessment.trading.domain.strategies;

import com.assessment.trading.domain.Algo;
import org.springframework.stereotype.Service;

@Service
public class Signal4Strategy implements Strategy {

  private static final int STRATEGY_ID = 4;

  @Override
  public int getStrategyId() {
    return STRATEGY_ID;
  }

  @Override
  public void execute(Algo algo) {
   // according to specs from JIRA
  }
}
