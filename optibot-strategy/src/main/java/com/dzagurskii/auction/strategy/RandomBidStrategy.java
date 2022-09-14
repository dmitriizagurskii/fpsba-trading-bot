package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.history.BidHistory;
import com.dzagurskii.auction.bidder.state.BidderState;

import java.util.Random;

/**
 * Calculates next bid by generating random value.
 */
public class RandomBidStrategy extends AbstractBidStrategy {

    Random random = new Random();

    @Override
    public int calculateBid(BidderState bidderState, BidHistory bidHistory) {
        int cashLeft = bidderState.getInitialCash() - bidHistory.getOwnBidSum();
        return random.nextInt(0, cashLeft + 1);
    }

}
