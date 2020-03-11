package br.com.holder.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestResource {

  @JsonProperty("name")
  private String cardHolderName;

  @JsonProperty("bank")
  private BankResource bankResource;

  public String getCardHolderName() {
    return cardHolderName;
  }

  public void setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  public BankResource getBankResource() {
    return bankResource;
  }

  public void setBankResource(BankResource bankResource) {
    this.bankResource = bankResource;
  }

  @Override
  public String toString() {
    return "RequestResource [cardHolderName=" + cardHolderName + ", bankResource=" + bankResource
        + "]";
  }

}
