package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.strategy.BidStrategy;

import java.util.Objects;

/**
 * Uses single {@link BidStrategy} provided in constructor.
 */
public class SingleStrategyBidder extends StrategyBidder {

    private final BidStrategy strategy;

    public SingleStrategyBidder(BidStrategy strategy) {
        Objects.requireNonNull(strategy, "Strategy can't be null");
        this.strategy = strategy;
    }

    @Override
    public BidStrategy calculateNextStrategy() {
        return strategy;
    }
}
