package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.history.BidHistory;
import com.dzagurskii.auction.bidder.state.BidderState;

/**
 * Calculates bid as remainingCash / remainingRounds.
 */
public class ConstantBidStrategy extends AbstractBidStrategy {
    @Override
    public int calculateBid(BidderState bidderState, BidHistory bidHistory) {
        int remainingRounds = (bidderState.getInitialQuantity() - bidHistory.getQuantitySold()) / 2;
        int remainingCash = bidderState.getInitialCash() - bidHistory.getOwnBidSum();
        return remainingCash / remainingRounds;
    }

}
