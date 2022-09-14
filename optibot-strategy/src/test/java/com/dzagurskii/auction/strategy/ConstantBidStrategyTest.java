package com.dzagurskii.auction.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantBidStrategyTest extends BidStrategyTest {

    @Test
    void calculateNextBid() {
        BidStrategy constantBidStrategy = new ConstantBidStrategy();

        int nextBid = constantBidStrategy.calculateNextBid(bidder.getBidderState(), bidder.getBidHistory());

        assertEquals(2, nextBid);
    }
}