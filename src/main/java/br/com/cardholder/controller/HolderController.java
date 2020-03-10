package br.com.cardholder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.cardholder.dto.CardHolderDataTransferObject;
import br.com.cardholder.resource.RequestResource;
import br.com.cardholder.service.HolderService;

@RestController
@RequestMapping("api/holder")
public class HolderController {

  @Autowired
  private HolderService validateTransactionService;

  @PostMapping("accomplish/sale")
  public ResponseEntity<Object> findBankAndCardHolderAndAccomplishSale(
      @Validated @RequestBody RequestResource request) {
    return validateTransactionService.findBankAndCardHolderAndAccomplishSale(request);
  }

  @PostMapping("save")
  public ResponseEntity<Object> save(
      @Validated @RequestBody CardHolderDataTransferObject cardHolderDTO) {
    return ResponseEntity.ok(validateTransactionService.save(cardHolderDTO));
  }

  @GetMapping("/scheduling")
  public ResponseEntity<String> scheduling() {
    return ResponseEntity.ok("OK");
  }

}
