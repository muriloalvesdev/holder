package br.com.holder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.holder.dto.CardHolderDataTransferObject;
import br.com.holder.resource.RequestResource;
import br.com.holder.service.HolderService;

@RestController
@RequestMapping("api/holder")
public class HolderController {

  @Autowired
  private HolderService validateTransactionService;

  @PostMapping("accomplish/sale")
  public ResponseEntity<Object> findBankAndCardHolderAndAccomplishSale(
      @RequestBody RequestResource request) {
    System.out.println("recebida requisicao: " + request);
    return validateTransactionService.findBankAndCardHolderAndAccomplishSale(request);
  }

  @PostMapping("save")
  public ResponseEntity<Object> save(@RequestBody CardHolderDataTransferObject cardHolderDTO) {
    validateTransactionService.save(cardHolderDTO);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/scheduling")
  public ResponseEntity<String> scheduling() {
    return ResponseEntity.ok("OK");
  }

}
