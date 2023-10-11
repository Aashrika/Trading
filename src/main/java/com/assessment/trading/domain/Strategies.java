package com.assessment.trading.domain;

import com.assessment.trading.domain.strategies.Signal1Strategy;
import com.assessment.trading.domain.strategies.Signal2Strategy;
import com.assessment.trading.domain.strategies.Signal3Strategy;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Strategies {

  private final Map<Integer, Runnable> signalWithStrategies = new HashMap<>();

  public Strategies(Signal1Strategy signal1Strategy, Signal2Strategy signal2Strategy, Signal3Strategy signal3Strategy) {
    signalWithStrategies.put(1, () -> signal1Strategy.execute(new Algo()));
    signalWithStrategies.put(2, () -> signal2Strategy.execute(new Algo()));
    signalWithStrategies.put(3, () -> signal3Strategy.execute(new Algo()));
    // Add more strategies per JIRA when needed...
  }
}

