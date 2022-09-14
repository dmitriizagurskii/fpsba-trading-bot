package com.dzagurskii.auction.webapp.impl.service;

import com.dzagurskii.auction.bidder.SingleStrategyBidder;
import com.dzagurskii.auction.bidder.StrategyBidder;
import com.dzagurskii.auction.strategy.BidStrategyHolder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class AdvancedStrategyBidderServiceTest {

    @Test
    void createBidder_returnAdvancedBidder() {
        AdvancedStrategyBidderService advancedStrategyBidderService = new AdvancedStrategyBidderService();
        StrategyBidder createdBidder = advancedStrategyBidderService.createBidder();
        assertInstanceOf(SingleStrategyBidder.class, createdBidder);

        assertEquals(BidStrategyHolder.ADVANCED_STRATEGY.getStrategy(), createdBidder.getStrategy());
    }
}