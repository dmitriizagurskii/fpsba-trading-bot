package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.StrategyBidder;

/**
 * Calculates next bid using average winning bid.
 */
public class AverageBidStrategy extends AbstractBidStrategy {
    @Override
    public int calculateBid(StrategyBidder bidder) {
        return bidder.getBidHistory().getAverageWinningBid().intValue();
    }

}
