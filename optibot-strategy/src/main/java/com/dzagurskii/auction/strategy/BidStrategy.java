package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.history.BidHistory;
import com.dzagurskii.auction.bidder.state.BidderState;

/**
 * Defines the algorithm using which the bid will be made.
 */
public interface BidStrategy {
    /**
     * Calculate next bid using bidderState of the bidder that places the bid.
     *
     * @param bidderState state of the Bidder that places the bid.
     * @param bidHistory record of all bids placed in the auction.
     * @return bid
     */
    int calculateNextBid(BidderState bidderState, BidHistory bidHistory);

}
