package com.dzagurskii.auction.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomBidStrategyTest extends BidStrategyTest {
    BidStrategy bidStrategy;

    @BeforeEach
    public void init() {
        super.init();
        bidStrategy = new RandomBidStrategy();
    }

    @Test
    public void calculateNextBidTest_whenRandom_thenInBounds() {
        int nextBid = bidStrategy.calculateNextBid(bidder.getBidderState(), bidder.getBidHistory());
        assertTrue(nextBid >= 0);
        assertTrue(nextBid <= 6);
    }

    @Test
    public void calculateNextBidTest_whenZeroCash_ThenZero() {
        Mockito.when(bidder.getBidHistory().getOwnBidSum()).thenReturn(10);

        int nextBid = bidStrategy.calculateNextBid(bidder.getBidderState(), bidder.getBidHistory());
        assertEquals(0, nextBid);
    }
}