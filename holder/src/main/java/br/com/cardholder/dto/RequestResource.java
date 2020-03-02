package br.com.cardholder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestResource {

  @JsonProperty("name")
  private String cardHolderName;

  @JsonProperty("bank")
  private BankDataTransferObject bankDTO;

  public String getCardHolderName() {
    return cardHolderName;
  }

  public void setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  public BankDataTransferObject getBankDTO() {
    return bankDTO;
  }

  public void setBankDTO(BankDataTransferObject bankDTO) {
    this.bankDTO = bankDTO;
  }

  @Override
  public String toString() {
    return "Request [cardHolderName=" + cardHolderName + ", bankDTO=" + bankDTO + "]";
  }

}
