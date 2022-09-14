package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.history.BidHistory;
import com.dzagurskii.auction.bidder.state.BidderState;

public class AdvancedBidStrategy implements BidStrategy {
    @Override
    public int calculateNextBid(BidderState bidderState, BidHistory bidHistory) {
        if (bidderState.getOwnQuantity() > bidderState.getOtherQuantity()
                || bidderState.getOwnCash() > bidderState.getOtherCash())
            return BidStrategyHolder.AVERAGE_STRATEGY.getStrategy().calculateNextBid(bidderState, bidHistory);
        return BidStrategyHolder.RANDOM_STRATEGY.getStrategy().calculateNextBid(bidderState, bidHistory);
    }
}
