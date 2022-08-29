package com.dzagurskii.auction.webapp.impl.service;

import com.dzagurskii.auction.bidder.AdvancedStrategyBidder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedStrategyBidderServiceTest {

    @Test
    void createBidder_returnAdvancedBidder() {
        AdvancedStrategyBidderService advancedStrategyBidderService = new AdvancedStrategyBidderService();
        assertInstanceOf(AdvancedStrategyBidder.class, advancedStrategyBidderService.createBidder());
    }
}