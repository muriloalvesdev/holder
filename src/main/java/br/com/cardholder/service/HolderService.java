package br.com.cardholder.service;

import org.springframework.http.ResponseEntity;
import br.com.cardholder.dto.CardHolderDataTransferObject;
import br.com.cardholder.resource.RequestResource;

public interface HolderService {
  CardHolderDataTransferObject save(CardHolderDataTransferObject cardHolderDTO);

  ResponseEntity<Object> findBankAndCardHolderAndAccomplishSale(RequestResource request);
}
