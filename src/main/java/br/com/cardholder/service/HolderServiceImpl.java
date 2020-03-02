package br.com.cardholder.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.cardholder.domain.model.Holder;
import br.com.cardholder.domain.repository.HolderRepository;
import br.com.cardholder.domain.utils.Bank;
import br.com.cardholder.domain.utils.HolderName;
import br.com.cardholder.dto.CardHolderDataTransferObject;
import br.com.cardholder.dto.RequestResource;
import br.com.cardholder.exception.CardHolderNameNotFoundException;

@Service
public class HolderServiceImpl implements HolderService {

  private static final Logger LOG = Logger.getLogger(HolderServiceImpl.class);

  @Autowired
  private HolderRepository cardHolderRepository;

  @Autowired
  private HolderComponent holderComponent;

  @Override
  public Holder save(CardHolderDataTransferObject cardHolderDTO) {
    try {
      HolderName holderName = HolderName.getCardHolderName(cardHolderDTO.getName());

      Bank bank = Bank.getBankName(cardHolderDTO.getBank());
      return cardHolderRepository.save(new Holder(holderName, bank));
    } catch (CardHolderNameNotFoundException e) {
      throw new RuntimeException("Error trying to save card banner: " + e.getMessage(), e);
    }

  }

  @Override
  public ResponseEntity<Object> findBankAndCardHolderAndAccomplishSale(
      RequestResource request) {
    LOG.info("Search CardHolder informed [ " + request.getCardHolderName() + " ]");
    try {
      findCardHolder(HolderName.getCardHolderName(request.getCardHolderName()));
    } catch (CardHolderNameNotFoundException e) {
      LOG.error(
          "CardHolder informed [ " + request.getCardHolderName() + " ] - Error: " + e.getMessage());
    }
    return holderComponent.sendRequest(request.getBankDTO());
  }

  private void findCardHolder(HolderName cardHolderName) throws CardHolderNameNotFoundException {
    cardHolderRepository.findByName(cardHolderName)
        .orElseThrow(() -> new CardHolderNameNotFoundException("card holder name not found!"));
  }

}
