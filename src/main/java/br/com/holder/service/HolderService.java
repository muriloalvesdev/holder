package br.com.holder.service;

import org.springframework.http.ResponseEntity;
import br.com.holder.dto.CardHolderDataTransferObject;
import br.com.holder.resource.RequestResource;

public interface HolderService {
  CardHolderDataTransferObject save(CardHolderDataTransferObject cardHolderDTO);

  ResponseEntity<Object> accomplishSale(RequestResource request);
}
