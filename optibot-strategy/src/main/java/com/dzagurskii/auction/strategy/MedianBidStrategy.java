package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.history.BidHistory;
import com.dzagurskii.auction.bidder.state.BidderState;

/**
 * Calculates next bid using median winning bid.
 */
public class MedianBidStrategy extends AbstractBidStrategy {
    @Override
    public int calculateBid(BidderState bidderState, BidHistory bidHistory) {
        return bidHistory.getMedianWinningBid();
    }
}
