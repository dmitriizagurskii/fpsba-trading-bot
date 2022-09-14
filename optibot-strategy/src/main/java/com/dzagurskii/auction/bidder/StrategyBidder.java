package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.bidder.exception.BidderNotInitializedException;
import com.dzagurskii.auction.strategy.BidStrategy;

/**
 * Calculates and uses {@link BidStrategy} in order to provide next bid.
 */
public interface StrategyBidder extends Bidder {

    BidStrategy getStrategy();

    default int calculateNextBidUsingStrategy() {
        if (!isInitialized()) {
            throw new BidderNotInitializedException();
        }
        return getStrategy().calculateNextBid(this.getBidderState(), this.getBidHistory());
    }
}
