package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.strategy.BidStrategyHolder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleStrategyBidderTest {

    @Test
    public void placeNextBidTest_whenStrategySet_thenUseStrategy() {
        SingleStrategyBidder bidder = new SingleStrategyBidder(BidStrategyHolder.ZERO_STRATEGY.getStrategy());

        bidder.init(10, 10);

        int nextBid = bidder.placeNextBid();
        assertEquals(0, nextBid);
    }
}