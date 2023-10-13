package com.assessment.trading.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Strategies {

  private final Map<Integer, Strategy> strategyMap = new HashMap<>();

  public Strategies(List<Strategy> strategies) {
    strategies.forEach(strategy -> strategyMap.put(strategy.getStrategyId(), strategy));
  }

  public void executeStrategy(int strategyId, Algo algo) {
    var strategy = strategyMap.get(strategyId);
    if (strategy != null) {
      strategy.execute(algo);
    } else {
      throw new IllegalArgumentException("Strategy not found for ID: " + strategyId);
    }
  }
}

