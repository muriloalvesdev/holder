package br.com.cardholder.service;

import org.springframework.http.ResponseEntity;

import br.com.cardholder.domain.model.Holder;
import br.com.cardholder.dto.CardHolderDataTransferObject;
import br.com.cardholder.dto.RequestResource;

public interface HolderService {
    Holder save(CardHolderDataTransferObject cardHolderDTO);

    ResponseEntity<Object> findBankAndCardHolderAndAccomplishSale(
            RequestResource request);
}
