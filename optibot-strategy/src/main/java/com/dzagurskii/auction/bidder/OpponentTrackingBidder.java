package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.bidder.state.BidderState;

/**
 * Tracks remaining cash and gained quantity of the opponent bidder.
 */
public abstract class OpponentTrackingBidder extends BasicBidder {
    @Override
    public void init(int quantity, int cash) {
        super.init(quantity, cash);
        BidderState bidderState = this.getBidderState();
        bidderState.setOtherQuantity(0);
        bidderState.setOtherCash(cash);
    }

    @Override
    public void bids(int own, int other) {
        super.bids(own, other);
        BidderState bidderState = getBidderState();
        bidderState.setOtherCash(bidderState.getOtherCash() - other);
        bidderState.setOtherQuantity(bidderState.getOtherQuantity() + getQuantityChange(other, own));
    }
}
