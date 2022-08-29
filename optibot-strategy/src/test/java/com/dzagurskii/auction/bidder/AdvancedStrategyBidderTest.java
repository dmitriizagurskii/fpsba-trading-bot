package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.strategy.AverageBidStrategy;
import com.dzagurskii.auction.strategy.BidStrategy;
import com.dzagurskii.auction.strategy.RandomBidStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AdvancedStrategyBidderTest {

    private AdvancedStrategyBidder bidder;

    @BeforeEach
    public void init() {
        bidder = Mockito.mock(AdvancedStrategyBidder.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    public void calculateNextStrategyTest_whenOwnQMoreOtherQ_thenAverageStrategy() {
        Mockito.when(bidder.getOwnQuantity()).thenReturn(20);
        Mockito.when(bidder.getOtherQuantity()).thenReturn(10);

        BidStrategy bidStrategy = bidder.calculateNextStrategy();
        assertInstanceOf(AverageBidStrategy.class, bidStrategy);
    }

    @Test
    public void calculateNextStrategyTest_whenOwnCMoreOtherC_thenAverageStrategy() {
        Mockito.when(bidder.getOwnCash()).thenReturn(20);
        Mockito.when(bidder.getOtherCash()).thenReturn(10);

        BidStrategy bidStrategy = bidder.calculateNextStrategy();
        assertInstanceOf(AverageBidStrategy.class, bidStrategy);
    }

    @Test
    public void calculateNextStrategyTest_whenDefault_thenRandomStrategy() {
        BidStrategy bidStrategy = bidder.calculateNextStrategy();
        assertInstanceOf(RandomBidStrategy.class, bidStrategy);
    }
}