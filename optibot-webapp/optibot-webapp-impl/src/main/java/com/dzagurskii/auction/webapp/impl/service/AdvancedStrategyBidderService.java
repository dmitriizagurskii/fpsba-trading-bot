package com.dzagurskii.auction.webapp.impl.service;

import com.dzagurskii.auction.bidder.AdvancedStrategyBidder;
import com.dzagurskii.auction.bidder.Bidder;
import org.springframework.stereotype.Service;

@Service
public class AdvancedStrategyBidderService extends AbstractBidderService {

    @Override
    Bidder createBidder() {
        return new AdvancedStrategyBidder();
    }
}
