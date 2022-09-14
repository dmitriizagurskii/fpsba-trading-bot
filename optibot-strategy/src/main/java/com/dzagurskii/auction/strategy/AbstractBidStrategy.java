package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.history.BidHistory;
import com.dzagurskii.auction.bidder.state.BidderState;

/**
 * After calculating the bid validates that the {@link com.dzagurskii.auction.bidder.Bidder Bidder} has enough cash to place it.
 */
public abstract class AbstractBidStrategy implements BidStrategy {
    @Override
    public final int calculateNextBid(BidderState bidderState, BidHistory bidHistory) {
        int nextBid = this.calculateBid(bidderState, bidHistory);
        int remainingCash = bidderState.getInitialCash() - bidHistory.getOwnBidSum();
        return Math.min(nextBid, remainingCash);
    }

    public abstract int calculateBid(BidderState bidderState, BidHistory bidHistory);
}
