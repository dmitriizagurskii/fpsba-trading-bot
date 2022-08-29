package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.bidder.exception.AuctionFinishedException;
import com.dzagurskii.auction.bidder.exception.BidderNotInitializedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class BasicBidderTest {
    private BasicBidder bidder;
    
    @BeforeEach
    public void init() {
        bidder = Mockito.mock(
                BasicBidder.class,
                Mockito.CALLS_REAL_METHODS);
    }
    
    @Test
    public void initTest() {
        bidder.init(1, 2);

        assertEquals(1, bidder.getInitialQuantity());
        assertEquals(2, bidder.getInitialCash());
        assertEquals(0, bidder.getOwnQuantity());
        assertEquals(2, bidder.getOwnCash());
        assertNotNull(bidder.getBidHistory());
    }

    @Test
    public void bidsTest_whenOwnGreaterOther_thenQuantityIncreaseBy2() {
        bidder.init(10, 10);
        
        bidder.bids(2, 1);

        assertEquals(10 - 2, bidder.getOwnCash());
        assertEquals(2, bidder.getOwnQuantity());
    }

    @Test
    public void bidsTest_whenOwnEqualsOther_thenQuantityIncreaseBy1() {
        bidder.init(10, 10);

        bidder.bids(2, 2);

        assertEquals(10 - 2, bidder.getOwnCash());
        assertEquals(1, bidder.getOwnQuantity());
    }

    @Test
    public void bidsTest_whenOwnLessOther_thenQuantityRemains() {
        bidder.init(10, 10);

        bidder.bids(2, 3);

        assertEquals(10 - 2, bidder.getOwnCash());
        assertEquals(0, bidder.getOwnQuantity());
    }

    @Test
    public void bidsTest_whenNotInitialized_thenException() {
        assertThrows(BidderNotInitializedException.class, () -> bidder.bids(2, 2));
    }

    @Test
    public void placeBidTest_whenNotInitialized_thenException() {
        assertThrows(BidderNotInitializedException.class, () -> bidder.placeBid());
    }

    @Test
    public void placeBidTest_whenAuctionFinished_thenException() {
        bidder.init(0, 0);
        assertThrows(AuctionFinishedException.class, () -> bidder.placeBid());
    }

    @Test
    public void placeBidTest_whenNoErrors_thenPlaceNextBid() {
        bidder.init(10, 10);
        int result = bidder.placeBid();
        assertEquals(0, result);
    }
}