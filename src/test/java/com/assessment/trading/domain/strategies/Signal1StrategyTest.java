package com.assessment.trading.domain.strategies;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.assessment.trading.domain.Algo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Signal1StrategyTest {

  @Spy
  Algo algo;

  @Test
  void shouldExecute(){
    //Arrange
    var signal1Strategy = new Signal1Strategy();
    //Act
    signal1Strategy.execute(algo);
    //Assert
    verify(algo, times(1)).setUp();
    verify(algo,times(1)).setAlgoParam(1,60);
    verify(algo,times(1)).performCalc();
    verify(algo,times(1)).submitToMarket();
    verifyNoMoreInteractions(algo);
  }

}