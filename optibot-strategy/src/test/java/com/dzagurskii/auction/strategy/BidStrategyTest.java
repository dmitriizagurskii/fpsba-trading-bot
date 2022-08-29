package com.dzagurskii.auction.strategy;

import com.dzagurskii.auction.bidder.StrategyBidder;
import com.dzagurskii.auction.bidder.history.BidHistory;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class BidStrategyTest {

    StrategyBidder bidder;

    @BeforeEach
    public void init() {
        bidder = Mockito.mock(StrategyBidder.class);

        BidHistory history = Mockito.mock(BidHistory.class);
        Mockito.when(history.getQuantitySold()).thenReturn(4);
        Mockito.when(history.getOwnBidSum()).thenReturn(4);

        Mockito.when(bidder.getBidHistory()).thenReturn(history);
        Mockito.when(bidder.getInitialCash()).thenReturn(10);
        Mockito.when(bidder.getInitialQuantity()).thenReturn(10);
    }
}
