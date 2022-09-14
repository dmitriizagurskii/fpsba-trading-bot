package com.dzagurskii.auction.bidder.state;

import com.dzagurskii.auction.bidder.Bidder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Holds initial quantity and cash provided in {@link  Bidder#init(int, int) init(quantity, cash)} method.
 * Tracks remaining cash and gained quantity.
 */
@Builder
@Getter
@Setter
public class BidderState {
    private boolean isInitialized;

    private int initialQuantity;
    private int initialCash;

    private int ownQuantity;
    private int ownCash;

    private int otherQuantity;
    private int otherCash;
}
