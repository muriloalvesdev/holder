package br.com.cardholder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CardHolderNameNotFoundException extends Exception {

  private static final long serialVersionUID = 7961115649580071150L;

  public CardHolderNameNotFoundException(String message) {
    super(message);
  }

}
