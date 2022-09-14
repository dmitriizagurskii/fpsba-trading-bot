package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.history.BidHistory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class AverageBidStrategyTest extends BidStrategyTest {

    @Test
    public void calculateNextBid() {
        BidHistory history = bidder.getBidHistory();
        Mockito.when(history.getAverageWinningBid()).thenReturn(4.0);

        BidStrategy constantBidStrategy = new AverageBidStrategy();

        int nextBid = constantBidStrategy.calculateNextBid(bidder.getBidderState(), history);

        assertEquals(4, nextBid);
    }
}