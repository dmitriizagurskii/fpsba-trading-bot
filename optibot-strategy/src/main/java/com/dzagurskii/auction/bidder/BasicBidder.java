package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.bidder.exception.AuctionFinishedException;
import com.dzagurskii.auction.bidder.exception.BidderNotInitializedException;
import com.dzagurskii.auction.bidder.history.BidHistory;
import com.dzagurskii.auction.bidder.history.ListBidHistory;

/**
 * Basic functionality for {@link Bidder} interface.
 * Keeps initial quantity and cash provided in {@link  Bidder#init(int, int) init(quantity, cash)} method.
 * Along with the history of all bids, tracks remaining cash and gained quantity.
 */
public abstract class BasicBidder implements Bidder {

    private int initialQuantity;
    private int initialCash;
    private int ownQuantity;
    private int ownCash;

    private BidHistory bidHistory;
    private boolean isInitialized;

    @Override
    public void init(int quantity, int cash) {
        this.initialQuantity = quantity;
        this.initialCash = cash;

        this.ownQuantity = 0;
        this.ownCash = cash;

        this.bidHistory = new ListBidHistory();
        this.isInitialized = true;
    }

    @Override
    public void bids(int own, int other) {
        validateInitialized();

        ownCash -= 2;
        ownQuantity += getQuantityChange(own, other);

        bidHistory.addEntry(own, other);
    }

    @Override
    public int placeBid() {
        validateInitialized();
        if (bidHistory.getQuantitySold() == initialQuantity) {
            throw new AuctionFinishedException();
        }
        return placeNextBid();
    }

    abstract int placeNextBid();

    int getQuantityChange(int own, int other) {
        return own > other ? 2 : own == other ? 1 : 0;
    }

    void validateInitialized() {
        if (!isInitialized) {
            throw new BidderNotInitializedException();
        }
    }

    public int getOwnQuantity() {
        return ownQuantity;
    }

    public int getOwnCash() {
        return ownCash;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public int getInitialCash() {
        return initialCash;
    }

    public BidHistory getBidHistory() {
        return bidHistory;
    }
}