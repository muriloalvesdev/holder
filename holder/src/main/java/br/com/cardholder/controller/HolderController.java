package br.com.cardholder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cardholder.dto.CardHolderDataTransferObject;
import br.com.cardholder.dto.RequestResource;
import br.com.cardholder.service.HolderService;

@RestController
@RequestMapping("api/holder")
public class HolderController {

    @Autowired
    private HolderService validateTransactionService;

    @PostMapping("accomplish/sale")
    public ResponseEntity<Object> findBankAndCardHolderAndAccomplishSale(
            @RequestBody RequestResource request) {
        return validateTransactionService
                .findBankAndCardHolderAndAccomplishSale(request);
    }

    @PostMapping("save")
    public ResponseEntity<Object> save(
            @RequestBody CardHolderDataTransferObject cardHolderDTO) {
        validateTransactionService.save(cardHolderDTO);
        return ResponseEntity.ok().build();
    }

}
