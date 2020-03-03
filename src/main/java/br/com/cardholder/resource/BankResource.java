package br.com.cardholder.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankResource {

  @JsonProperty("amount_sale")
  private String amountSale;

  @JsonProperty("card")
  private CardResource card;

  public String getAmountSale() {
    return amountSale;
  }

  public CardResource getCard() {
    return card;
  }

  public void setCard(CardResource card) {
    this.card = card;
  }

  public void setAmountSale(String amountSale) {
    this.amountSale = amountSale;
  }

  @Override
  public String toString() {
    return "BankResource [amountSale=" + amountSale + ", card=" + card + "]";
  }

}
