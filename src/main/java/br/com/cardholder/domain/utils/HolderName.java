package br.com.cardholder.domain.utils;

import java.util.Arrays;

import br.com.cardholder.exception.CardHolderNameNotFoundException;

public enum HolderName {
    MASTERCARD("MASTERCARD");

    private String cardHolderName;

    private HolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    private String getCardHolderName() {
        return cardHolderName;
    }

    public static HolderName getCardHolderName(String cardHolderName)
            throws CardHolderNameNotFoundException {
        return Arrays.asList(HolderName.values()).stream()
                .filter(cardHolder -> cardHolder.getCardHolderName()
                        .equals(cardHolderName.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new CardHolderNameNotFoundException(
                        "Card Holder Not Found!"));
    }
}
