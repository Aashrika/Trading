package com.assessment.trading.service;

import com.assessment.trading.domain.Algo;
import com.assessment.trading.domain.SignalHandler;
import com.assessment.trading.domain.Strategies;
import com.assessment.trading.domain.strategies.DefaultSignalStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TradingService implements SignalHandler {

  private final Strategies strategies;
  private final DefaultSignalStrategy defaultSignalStrategy;

  @Override
  public void handleSignal(int signal) {
    var signalWithStrategies = strategies.getSignalWithStrategies();
    if (signalWithStrategies.containsKey(signal)) {
      signalWithStrategies.get(signal).run();
      log.info("Signal: {}" , signal +" is processed.");
    } else {
      log.warn("Unexpected Signal received.");
      defaultSignalStrategy.execute(new Algo());
    }
  }
}
