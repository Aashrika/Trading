package com.assessment.trading.controller;

import com.assessment.trading.service.SignalHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TradingController {

  private final SignalHandler singleHandler;

  @PostMapping(value = "/trade", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> executeSignalStrategy(@RequestParam int signal) {
    singleHandler.handleSignal(signal);
    return ResponseEntity.ok().body("Trading signal :"+ signal + " executed.");
  }

}


