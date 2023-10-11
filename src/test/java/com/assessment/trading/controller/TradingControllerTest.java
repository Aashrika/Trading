package com.assessment.trading.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import com.assessment.trading.service.TradingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class TradingControllerTest {

  private TradingController tradingController;

  @Mock
  private TradingService tradingService;

  @BeforeEach
  void setUp() {
    tradingController = new TradingController(tradingService);
  }

  @Test
  void executeSignalStrategy() {
    //Arrange
    var signal = 1;

    //Act
    final var trading = tradingController.executeSignalStrategy(signal);

    //Assert
    verify(tradingService).handleSignal(signal);
    assertThat(trading.getStatusCode()).isEqualTo(HttpStatus.OK);
  }
}