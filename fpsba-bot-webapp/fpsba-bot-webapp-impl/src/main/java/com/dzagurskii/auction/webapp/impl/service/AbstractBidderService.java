package com.dzagurskii.auction.webapp.impl.service;

import com.dzagurskii.auction.bidder.Bidder;
import com.dzagurskii.auction.bidder.exception.BidderNotInitializedException;
import com.dzagurskii.auction.webapp.api.model.BidderInitializationRequest;
import com.dzagurskii.auction.webapp.api.model.SaveBidsRequest;
import com.dzagurskii.auction.webapp.api.service.BidderService;

/**
 * Basic functionality using {@link Bidder} as a bidder entity.
 */
public abstract class AbstractBidderService implements BidderService {
    private Bidder bidder;

    @Override
    public void initializeBidder(BidderInitializationRequest initializationRequest) {
        bidder = createBidder();
        bidder.init(initializationRequest.getQuantity(), initializationRequest.getCash());
    }

    abstract Bidder createBidder();

    @Override
    public Integer getNextBid() {
        validateBidder();
        return bidder.placeBid();
    }

    @Override
    public void saveBids(SaveBidsRequest bidsRequest) {
        validateBidder();
        bidder.bids(bidsRequest.getOwn(), bidsRequest.getOther());
    }

    private void validateBidder() {
        if (bidder == null) {
            throw new BidderNotInitializedException();
        }
    }

}
