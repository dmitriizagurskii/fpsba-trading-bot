package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.history.BidHistory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class MedianBidStrategyTest extends BidStrategyTest {
    @Test
    void calculateNextBid() {
        BidHistory history = bidder.getBidHistory();
        Mockito.when(history.getMedianWinningBid()).thenReturn(4);

        BidStrategy constantBidStrategy = new MedianBidStrategy();

        int nextBid = constantBidStrategy.calculateNextBid(bidder.getBidderState(), history);

        assertEquals(4, nextBid);
    }
}