package br.com.holder.service;

import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.holder.domain.model.Holder;
import br.com.holder.domain.repository.HolderRepository;
import br.com.holder.domain.utils.Bank;
import br.com.holder.domain.utils.HolderName;
import br.com.holder.dto.CardHolderDataTransferObject;
import br.com.holder.exception.CardHolderNameNotFoundException;
import br.com.holder.resource.RequestResource;

@Service
public class HolderServiceImpl implements HolderService {

  private static final Logger LOG = Logger.getLogger(HolderServiceImpl.class);

  private HolderRepository cardHolderRepository;
  private SendRequest sendRequest;

  public HolderServiceImpl(HolderRepository cardHolderRepository, SendRequest sendRequest) {
    this.cardHolderRepository = cardHolderRepository;
    this.sendRequest = sendRequest;
  }

  @Override
  public CardHolderDataTransferObject save(CardHolderDataTransferObject cardHolderDTO) {
    try {

      HolderName holderName = HolderName.getCardHolderName(cardHolderDTO.getName());
      Bank bank = Bank.getBankName(cardHolderDTO.getBank());
      cardHolderRepository.saveAndFlush(new Holder(holderName, bank));

    } catch (CardHolderNameNotFoundException e) {
      LOG.error("Error trying to save card banner: " + e.getMessage(), e);
    }

    return cardHolderDTO;
  }

  @Override
  public ResponseEntity<Object> accomplishSale(RequestResource request) {
    LOG.info("Search CardHolder informed [ " + request.getCardHolderName() + " ]");
    try {
      findCardHolder(HolderName.getCardHolderName(request.getCardHolderName()));
    } catch (CardHolderNameNotFoundException e) {
      LOG.error(
          "CardHolder informed [ " + request.getCardHolderName() + " ] - Error: " + e.getMessage());
    }
    return sendRequest.send(request.getBankResource());
  }

  private void findCardHolder(HolderName cardHolderName) throws CardHolderNameNotFoundException {
    cardHolderRepository.findByName(cardHolderName)
        .orElseThrow(() -> new CardHolderNameNotFoundException("card holder name not found!"));
  }

}
