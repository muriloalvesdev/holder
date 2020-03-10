package br.com.cardholder.exception;

public class BankNameNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -6580892535718231567L;

  public BankNameNotFoundException(String message) {
    super(message);
  }

}
