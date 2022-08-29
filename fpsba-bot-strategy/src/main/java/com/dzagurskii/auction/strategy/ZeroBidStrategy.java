package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.StrategyBidder;

/**
 * Always returns 0 as next bid.
 */
public class ZeroBidStrategy extends AbstractBidStrategy {
    @Override
    public int calculateBid(StrategyBidder bidder) {
        return 0;
    }

}
