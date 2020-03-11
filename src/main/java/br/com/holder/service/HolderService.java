package br.com.holder.service;

import org.springframework.http.ResponseEntity;
import br.com.holder.domain.model.Holder;
import br.com.holder.dto.CardHolderDataTransferObject;
import br.com.holder.resource.RequestResource;

public interface HolderService {
  Holder save(CardHolderDataTransferObject cardHolderDTO);

  ResponseEntity<Object> findBankAndCardHolderAndAccomplishSale(RequestResource request);
}
