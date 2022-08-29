package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.StrategyBidder;

/**
 * Defines the algorithm using which the bid will be made.
 */
public interface BidStrategy {
    /**
     * Calculate next bid using bidder that places the bid.
     * @param bidder
     * Bidder that places the bid.
     * @return bid
     */
    int calculateNextBid(StrategyBidder bidder);

}
