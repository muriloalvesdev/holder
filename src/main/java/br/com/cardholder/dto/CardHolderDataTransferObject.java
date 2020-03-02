package br.com.cardholder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardHolderDataTransferObject {

    @JsonProperty("name")
    private String name;

    @JsonProperty("bank_name")
    private String bank;

    public String getName() {
        return name;
    }

    public String getBank() {
        return bank;
    }

}
