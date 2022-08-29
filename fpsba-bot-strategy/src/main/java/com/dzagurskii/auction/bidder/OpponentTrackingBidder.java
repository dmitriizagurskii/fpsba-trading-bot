package com.dzagurskii.auction.bidder;

/**
 * Tracks remaining cash and gained quantity of the opponent bidder.
 */
public abstract class OpponentTrackingBidder extends StrategyBidder {
    private int otherQuantity;
    private int otherCash;

    @Override
    public void init(int quantity, int cash) {
        super.init(quantity, cash);
        this.otherQuantity = 0;
        this.otherCash = cash;
    }

    @Override
    public void bids(int own, int other) {
        super.bids(own, other);
        this.otherCash -= other;
        this.otherQuantity += getQuantityChange(other, own);
    }

    public int getOtherQuantity() {
        return otherQuantity;
    }

    public int getOtherCash() {
        return otherCash;
    }
}
