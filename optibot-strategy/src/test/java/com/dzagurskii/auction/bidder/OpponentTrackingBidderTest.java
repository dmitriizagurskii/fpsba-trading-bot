package com.dzagurskii.auction.bidder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class OpponentTrackingBidderTest {

    private OpponentTrackingBidder bidder;

    @BeforeEach
    public void init() {
        bidder = Mockito.mock(
                OpponentTrackingBidder.class,
                Mockito.CALLS_REAL_METHODS);
    }

    @Test
    public void initTest() {
        bidder.init(10, 10);

        assertEquals(0, bidder.getBidderState().getOtherQuantity());
        assertEquals(10, bidder.getBidderState().getOtherCash());
    }

    @Test
    public void bidsTest_whenOtherGreaterOwn_thenQuantityIncreaseBy2() {
        bidder.init(10, 10);

        bidder.bids(1, 2);

        assertEquals(10 - 2, bidder.getBidderState().getOtherCash());
        assertEquals(2, bidder.getBidderState().getOtherQuantity());
    }

    @Test
    public void bidsTest_whenOtherEqualsOwn_thenQuantityIncreaseBy1() {
        bidder.init(10, 10);

        bidder.bids(2, 2);

        assertEquals(10 - 2, bidder.getBidderState().getOtherCash());
        assertEquals(1, bidder.getBidderState().getOtherQuantity());
    }

    @Test
    public void bidsTest_whenOtherLessOwn_thenQuantityRemains() {
        bidder.init(10, 10);

        bidder.bids(3, 2);

        assertEquals(10 - 2, bidder.getBidderState().getOtherCash());
        assertEquals(0, bidder.getBidderState().getOtherQuantity());
    }
}