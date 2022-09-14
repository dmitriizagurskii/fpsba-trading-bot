package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.history.BidHistory;
import com.dzagurskii.auction.bidder.state.BidderState;

/**
 * Calculates next bid using average winning bid.
 */
public class AverageBidStrategy extends AbstractBidStrategy {
    @Override
    public int calculateBid(BidderState bidderState, BidHistory bidHistory) {
        return (int) bidHistory.getAverageWinningBid();
    }

}
