package com.dzagurskii.auction.bidder.exception;

public class AuctionFinishedException extends BidderException {
    public AuctionFinishedException() {
        super("Impossible to perform operation, auction was finished.");
    }
}
