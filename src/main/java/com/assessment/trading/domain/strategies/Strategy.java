package com.assessment.trading.domain.strategies;

import com.assessment.trading.domain.Algo;

public interface Strategy {

  int getStrategyId();

  void execute(Algo algo);

}
