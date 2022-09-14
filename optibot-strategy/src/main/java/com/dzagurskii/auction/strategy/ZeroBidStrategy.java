package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.history.BidHistory;
import com.dzagurskii.auction.bidder.state.BidderState;

/**
 * Always returns 0 as next bid.
 */
public class ZeroBidStrategy extends AbstractBidStrategy {
    @Override
    public int calculateBid(BidderState bidderState, BidHistory bidHistory) {
        return 0;
    }

}
