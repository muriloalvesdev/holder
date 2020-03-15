package br.com.holder.domain.utils;

import java.security.InvalidParameterException;
import java.util.Arrays;

public enum HolderName {
  MASTERCARD("MASTERCARD");

  private String cardHolderName;

  private HolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  private String getCardHolderName() {
    return cardHolderName;
  }

  public static HolderName getHolderName(String cardHolderName) {
    return Arrays.asList(HolderName.values()).stream()
        .filter(cardHolder -> cardHolder.getCardHolderName().equals(cardHolderName.toUpperCase()))
        .findFirst().orElseThrow(() -> new InvalidParameterException("Card Holder Not Found!"));
  }
}
