package com.dzagurskii.auction.bidder;

import com.dzagurskii.auction.bidder.exception.AuctionFinishedException;
import com.dzagurskii.auction.bidder.exception.BidderNotInitializedException;
import com.dzagurskii.auction.bidder.history.BidHistory;
import com.dzagurskii.auction.bidder.history.ListBidHistory;
import com.dzagurskii.auction.bidder.state.BidderState;
import lombok.Getter;

/**
 * Basic functionality for {@link Bidder} interface.
 * Keeps and updates bidder state and bid history.
 */
@Getter
public abstract class BasicBidder implements Bidder {

    private BidderState bidderState;

    private BidHistory bidHistory;

    @Override
    public void init(int quantity, int cash) {
        bidderState = BidderState.builder()
                .isInitialized(true)
                .initialQuantity(quantity)
                .initialCash(cash)
                .ownQuantity(0)
                .ownCash(cash)
                .build();

        this.bidHistory = new ListBidHistory();
    }

    @Override
    public void bids(int own, int other) {
        if (!isInitialized()) {
            throw new BidderNotInitializedException();
        }

        bidderState.setOwnCash(bidderState.getOwnCash() - own);
        bidderState.setOwnQuantity(bidderState.getOwnQuantity() + getQuantityChange(own, other));

        bidHistory.addEntry(own, other);
    }

    @Override
    public final int placeBid() {
        if (!isInitialized()) {
            throw new BidderNotInitializedException();
        }
        if (bidHistory.getQuantitySold() == bidderState.getInitialQuantity()) {
            throw new AuctionFinishedException();
        }
        return placeNextBid();
    }

    abstract int placeNextBid();

    public static int getQuantityChange(int own, int other) {
        return own > other ? 2 : own == other ? 1 : 0;
    }
}