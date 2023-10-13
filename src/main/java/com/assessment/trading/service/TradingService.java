package com.assessment.trading.service;

import com.assessment.trading.domain.Algo;
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
    try {
      strategies.executeStrategy(signal, new Algo());
      log.info("Signal: {} is processed.", signal);
    } catch (IllegalArgumentException e) {
      log.warn("Unexpected Signal received.");
      defaultSignalStrategy.execute(new Algo());
    }
  }
}
