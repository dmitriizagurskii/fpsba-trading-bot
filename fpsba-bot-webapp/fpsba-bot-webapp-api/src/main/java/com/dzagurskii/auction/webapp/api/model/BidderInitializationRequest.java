package com.dzagurskii.auction.webapp.api.model;

/**
 * DTO used for Bidder initialization request
 */
public class BidderInitializationRequest {
    private int cash;
    private int quantity;

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InitializationRequest{" +
                "cash=" + cash +
                ", quantity=" + quantity +
                '}';
    }
}
