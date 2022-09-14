package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.strategy.BidStrategy;
import lombok.Getter;

import java.util.Objects;

/**
 * Uses single {@link BidStrategy} provided in constructor.
 */
@Getter
public class SingleStrategyBidder extends OpponentTrackingBidder implements StrategyBidder {

    private final BidStrategy strategy;

    public SingleStrategyBidder(BidStrategy strategy) {
        Objects.requireNonNull(strategy, "Strategy can't be null");
        this.strategy = strategy;
    }

    @Override
    int placeNextBid() {
        return calculateNextBidUsingStrategy();
    }
}
