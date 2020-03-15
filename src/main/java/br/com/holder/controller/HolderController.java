package br.com.holder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
  public ResponseEntity<Object> accomplishSale(@Validated @RequestBody RequestResource request) {
    return validateTransactionService.accomplishSale(request);
  }

  @PostMapping("save")
  public ResponseEntity<Object> save(
      @Validated @RequestBody CardHolderDataTransferObject cardHolderDTO) {
    validateTransactionService.save(cardHolderDTO);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/")
  public ResponseEntity<String> ok() {
    return ResponseEntity.ok("OK");
  }

}
