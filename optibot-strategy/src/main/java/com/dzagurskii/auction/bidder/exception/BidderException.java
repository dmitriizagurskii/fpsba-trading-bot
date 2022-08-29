package com.dzagurskii.auction.bidder.exception;

/**
 * Thrown in case of any {@link com.dzagurskii.auction.bidder.Bidder Bidder} related exception.
 * @see AuctionFinishedException
 * @see BidderNotInitializedException
 */
public class BidderException extends RuntimeException {
    public BidderException(String message) {
        super(message);
    }
}
