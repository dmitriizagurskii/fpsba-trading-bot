package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.strategy.BidStrategy;
import com.dzagurskii.auction.strategy.BidStrategyHolder;

/**
 * Uses multiple {@link BidStrategy Bid Strategies} in order to perform optimally at the auction.
 */
public class AdvancedStrategyBidder extends OpponentTrackingBidder {

    @Override
    public BidStrategy calculateNextStrategy() {
        if (getOwnQuantity() > getOtherQuantity() || getOwnCash() > getOtherCash())
            return BidStrategyHolder.AVERAGE_STRATEGY.getStrategy();
        return BidStrategyHolder.RANDOM_STRATEGY.getStrategy();
    }
}
