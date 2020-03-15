package br.com.holder.resource;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankResource {

  @JsonProperty("amount_sale")
  @NotNull(message = "amount_sale is required!")
  private String amountSale;

  @JsonProperty("card")
  @NotNull(message = "card is required!")
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
