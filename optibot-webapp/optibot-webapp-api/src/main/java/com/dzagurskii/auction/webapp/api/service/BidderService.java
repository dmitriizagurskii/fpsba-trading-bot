package com.dzagurskii.auction.webapp.api.service;

import com.dzagurskii.auction.webapp.api.model.SaveBidsRequest;
import com.dzagurskii.auction.webapp.api.model.BidderInitializationRequest;

/**
 * Manage Bidder entity
 */
public interface BidderService {

    /**
     * Set auction initial information to the Bidder
     * @param initializationRequest
     * Initial state for the Bidder received from the auction manager
     */
    void initializeBidder(BidderInitializationRequest initializationRequest);
    /**
     * Return next bid placed by the bidder
     * @return next bid
     */
    Integer getNextBid();
    /**
     * Update bidder with the latest information from the auction
     * @param bidsRequest
     * Latest round bids received from the auction manager
     */
    void saveBids(SaveBidsRequest bidsRequest);

}
