package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.strategy.BidStrategy;

/**
 * Calculates and uses {@link BidStrategy} in order to provide next bid.
 */
public abstract class StrategyBidder extends BasicBidder {

    BidStrategy calculateStrategy() {
        validateInitialized();
        return calculateNextStrategy();
    }

    protected abstract BidStrategy calculateNextStrategy();

    @Override
    int placeNextBid() {
        return calculateStrategy().calculateNextBid(this);
    }
}
