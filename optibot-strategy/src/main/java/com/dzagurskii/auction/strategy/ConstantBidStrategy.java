package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.StrategyBidder;

/**
 * Calculates bid as remainingCash / remainingRounds.
 */
public class ConstantBidStrategy extends AbstractBidStrategy {
    @Override
    public int calculateBid(StrategyBidder bidder) {
        int remainingRounds = (bidder.getInitialQuantity() - bidder.getBidHistory().getQuantitySold()) / 2;
        int remainingCash = bidder.getInitialCash() - bidder.getBidHistory().getOwnBidSum();
        return remainingCash / remainingRounds;
    }

}
