package com.dzagurskii.auction.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZeroBidStrategyTest extends BidStrategyTest {

    @Test
    void calculateNextBid() {
        BidStrategy zeroBidStrategy = new ZeroBidStrategy();
        int nextBid = zeroBidStrategy.calculateNextBid(bidder);

        assertEquals(0, nextBid);
    }
}