package com.assessment.trading.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.assessment.trading.domain.Algo;
import com.assessment.trading.domain.Strategies;
import com.assessment.trading.domain.strategies.DefaultSignalStrategy;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TradingServiceTest {

  @Mock
  private Strategies strategies;

  @Mock
  private DefaultSignalStrategy defaultSignalStrategy;

  private TradingService tradingService;
  @BeforeEach
  void setUp() {
  tradingService = new TradingService(strategies,defaultSignalStrategy);
  }

  @Test
  public void shouldHandleValidSignal() {
    //Arrange
    int validSignal = 123;
    Runnable mockRunnable = Mockito.mock(Runnable.class);
    when(strategies.getSignalWithStrategies()).thenReturn(Map.of(validSignal, mockRunnable));

    // Act
    tradingService.handleSignal(validSignal);

    // Assert
    verify(mockRunnable).run();
  }

  @Test
  public void shouldHandleUnexpectedSignal() {
    // Arrange
    int unexpectedSignal = 456;

    when(strategies.getSignalWithStrategies()).thenReturn(Map.of());

    // Act
    tradingService.handleSignal(unexpectedSignal);

    // Assert
    verify(defaultSignalStrategy).execute(Mockito.any(Algo.class));
  }

}
