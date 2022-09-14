package com.dzagurskii.auction.webapp.impl.service;

import com.dzagurskii.auction.bidder.SingleStrategyBidder;
import com.dzagurskii.auction.bidder.StrategyBidder;
import com.dzagurskii.auction.strategy.BidStrategyHolder;
import org.springframework.stereotype.Service;

@Service
public class AdvancedStrategyBidderService extends AbstractBidderService {

    @Override
    StrategyBidder createBidder() {
        return new SingleStrategyBidder(BidStrategyHolder.ADVANCED_STRATEGY.getStrategy());
    }
}
