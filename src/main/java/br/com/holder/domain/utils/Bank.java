package br.com.holder.domain.utils;

import java.security.InvalidParameterException;
import java.util.Arrays;

public enum Bank {
  NUBANK("NUBANK");

  private String bankName;

  private Bank(String bankName) {
    this.bankName = bankName;
  }

  private String getBankName() {
    return bankName;
  }

  public static Bank getBankName(String bankName) {
    return Arrays.asList(Bank.values()).stream()
        .filter(bank -> bank.getBankName().equals(bankName.toUpperCase())).findFirst()
        .orElseThrow(() -> new InvalidParameterException("Bank Name not found!"));
  }
}
