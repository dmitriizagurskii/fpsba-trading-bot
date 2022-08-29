package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.StrategyBidder;

import java.util.Random;

/**
 * Calculates next bid by generating random value.
 */
public class RandomBidStrategy extends AbstractBidStrategy {

    Random random = new Random();

    @Override
    public int calculateBid(StrategyBidder bidder) {
        int cashLeft = bidder.getInitialCash() - bidder.getBidHistory().getOwnBidSum();
        return random.nextInt(0, cashLeft + 1);
    }

}
