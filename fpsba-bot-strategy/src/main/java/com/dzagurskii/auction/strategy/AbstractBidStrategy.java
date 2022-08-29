package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.StrategyBidder;

/**
 * After calculating the bid validates that the {@link com.dzagurskii.auction.bidder.Bidder Bidder} has enough cash to place it.
 */
public abstract class AbstractBidStrategy implements BidStrategy {
    @Override
    public int calculateNextBid(StrategyBidder bidder) {
        int nextBid = this.calculateBid(bidder);
        int remainingCash = bidder.getInitialCash() - bidder.getBidHistory().getOwnBidSum();
        return Math.min(nextBid, remainingCash);
    }

    public abstract int calculateBid(StrategyBidder bidder);
}
