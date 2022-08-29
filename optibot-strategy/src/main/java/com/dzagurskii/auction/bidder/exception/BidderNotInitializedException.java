package com.dzagurskii.auction.bidder.exception;

public class BidderNotInitializedException extends BidderException {
    public BidderNotInitializedException() {
        super("Impossible to perform operation, builder was not initialized.");
    }
}
