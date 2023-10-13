package com.assessment.trading.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import com.assessment.trading.domain.Algo;
import com.assessment.trading.domain.Strategies;
import com.assessment.trading.domain.strategies.DefaultSignalStrategy;
import com.assessment.trading.domain.strategies.Signal1Strategy;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TradingServiceTest {

  @Spy
  private Signal1Strategy signal1Strategy;

  @Mock
  private DefaultSignalStrategy defaultSignalStrategy;

  private TradingService tradingService;

  @BeforeEach
  void setUp() {
    Strategies strategies = new Strategies(List.of(signal1Strategy));
    tradingService = new TradingService(strategies, defaultSignalStrategy);
  }

  @Test
  public void shouldHandleValidSignal() {
    // Arrange
    int validSignal = 1;
    // Act
    tradingService.handleSignal(validSignal);

    // Assert
    verify(signal1Strategy).execute(any(Algo.class));

  }

  @Test
  public void shouldHandleUnexpectedSignal() {
    // Arrange
    int unexpectedSignal = 456;

    // Act
    tradingService.handleSignal(unexpectedSignal);

    // Assert
    verify(signal1Strategy, atLeast(0)).execute(any(Algo.class));
    verify(defaultSignalStrategy).execute(any(Algo.class));
  }

}
