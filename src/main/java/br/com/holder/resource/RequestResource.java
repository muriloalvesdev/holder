package br.com.holder.resource;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestResource {

  @JsonProperty("name")
  @NotNull(message = "name is required!")
  private String cardHolderName;

  @JsonProperty("bank")
  @NotNull(message = "bank is required!")
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
