package com.assessment.trading.domain.strategies;

import com.assessment.trading.domain.Algo;
import com.assessment.trading.domain.SignalStrategy;
import org.springframework.stereotype.Service;

@Service
public class Signal2Strategy implements SignalStrategy {

  @Override
  public void execute(Algo algo) {
    algo.reverse();
    algo.setAlgoParam(1, 80);
    algo.submitToMarket();
  }
}
