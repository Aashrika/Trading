package com.assessment.trading.domain.strategies;

import com.assessment.trading.domain.Algo;
import com.assessment.trading.domain.SignalStrategy;
import org.springframework.stereotype.Service;

@Service
public class Signal1Strategy implements SignalStrategy {

  @Override
  public void execute(Algo algo) {
    algo.setUp();
    algo.setAlgoParam(1, 60);
    algo.performCalc();
    algo.submitToMarket();
  }
}
