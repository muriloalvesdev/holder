package br.com.holder.service;

import java.security.InvalidParameterException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.holder.domain.model.Holder;
import br.com.holder.domain.repository.HolderRepository;
import br.com.holder.domain.utils.Bank;
import br.com.holder.domain.utils.HolderName;
import br.com.holder.dto.CardHolderDataTransferObject;
import br.com.holder.resource.RequestResource;

@Service
public class HolderServiceImpl implements HolderService {

  private HolderRepository cardHolderRepository;
  private SendRequest sendRequest;

  public HolderServiceImpl(HolderRepository cardHolderRepository, SendRequest sendRequest) {
    this.cardHolderRepository = cardHolderRepository;
    this.sendRequest = sendRequest;
  }

  @Override
  public CardHolderDataTransferObject save(CardHolderDataTransferObject cardHolderDTO) {
    HolderName holderName = HolderName.getHolderName(cardHolderDTO.getName());
    Bank bank = Bank.getBankName(cardHolderDTO.getBank());
    cardHolderRepository.saveAndFlush(new Holder(holderName, bank));

    return cardHolderDTO;
  }

  @Override
  public ResponseEntity<Object> accomplishSale(RequestResource request) {
    findCardHolder(HolderName.getHolderName(request.getCardHolderName()));
    return sendRequest.send(request.getBankResource());
  }

  private void findCardHolder(HolderName holderName) {
    cardHolderRepository.findByName(holderName).orElseThrow(
        () -> new InvalidParameterException("Holder informed [" + holderName + " not found!"));
  }

}
