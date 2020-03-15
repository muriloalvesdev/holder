package br.com.holder.dto;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardHolderDataTransferObject {

  @JsonProperty("name")
  @NotNull(message = "name is required!")
  private String name;

  @JsonProperty("bank_name")
  @NotNull(message = "bank_name is required!")
  private String bank;

  public String getName() {
    return name;
  }

  public String getBank() {
    return bank;
  }

}
