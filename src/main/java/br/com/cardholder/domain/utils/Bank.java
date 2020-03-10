package br.com.cardholder.domain.utils;

import java.util.Arrays;

import br.com.cardholder.exception.BankNameNotFoundException;

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
        .orElseThrow(() -> new BankNameNotFoundException("Bank Name not found!"));
  }
}
