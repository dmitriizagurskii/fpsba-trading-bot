package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.bidder.exception.BidderNotInitializedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyBidderTest {

    private StrategyBidder bidder;

    @BeforeEach
    public void init() {
        this.bidder = Mockito.mock(StrategyBidder.class, Mockito.CALLS_REAL_METHODS);
    }
    @Test
    public void calculateStrategy_whenNotInitialized_thenException() {
        assertThrows(BidderNotInitializedException.class, () -> bidder.calculateNextBidUsingStrategy());
    }
}