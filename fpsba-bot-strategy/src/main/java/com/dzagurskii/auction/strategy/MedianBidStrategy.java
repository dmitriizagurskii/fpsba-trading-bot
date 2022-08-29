package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.StrategyBidder;

/**
 * Calculates next bid using median winning bid.
 */
public class MedianBidStrategy extends AbstractBidStrategy {
    @Override
    public int calculateBid(StrategyBidder bidder) {
        return bidder.getBidHistory().getMedianWinningBid();
    }
}
