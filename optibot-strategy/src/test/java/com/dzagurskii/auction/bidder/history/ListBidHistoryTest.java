package com.dzagurskii.auction.bidder.history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListBidHistoryTest {
    private BidHistory bidHistory;

    @BeforeEach
    public void init() {
        this.bidHistory = new ListBidHistory();
    }

    @Test
    public void getOwnBidSumTest() {
        bidHistory.addEntry(10, 20);
        bidHistory.addEntry(10, 20);

        int ownBidSum = bidHistory.getOwnBidSum();
        assertEquals(20, ownBidSum);
    }

    @Test
    public void getOtherBidSumTest() {
        bidHistory.addEntry(10, 20);
        bidHistory.addEntry(10, 20);

        int otherBidSum = bidHistory.getOtherBidSum();
        assertEquals(40, otherBidSum);
    }

    @Test
    public void getQuantitySoldTest() {
        bidHistory.addEntry(10, 10);
        bidHistory.addEntry(10, 10);
        bidHistory.addEntry(10, 10);

        int quantitySold = bidHistory.getQuantitySold();
        assertEquals(6, quantitySold);
    }
}