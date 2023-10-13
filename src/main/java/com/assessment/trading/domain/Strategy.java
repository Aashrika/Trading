package com.assessment.trading.domain;

public interface Strategy {

  int getStrategyId();

  void execute(Algo algo);

}
