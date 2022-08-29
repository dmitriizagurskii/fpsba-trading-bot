package com.dzagurskii.auction.bidder.history;

/**
 * Used to track all bids made in a single auction.
 */
public interface BidHistory {

    /**
     * Add results of the auction round.
     * @param own
     * Own bid amount
     * @param other
     * Opponent's bid amount
     */
    void addEntry(int own, int other);

    /**
     * Calculate the sum of all bids made by the bidder.
     * @return sum of all own bids.
     */
    int getOwnBidSum();
    /**
     * Calculate the sum of all bids made by the opponent bidder.
     * @return sum of all other bids.
     */
    int getOtherBidSum();
    /**
     * Calculate the amount of products sold.
     * @return amount of products sold.
     */
    int getQuantitySold();
    /**
     * Calculate the average winning bid in the auction.
     * @return average amongst all recorded winning bids.
     */
    Double getAverageWinningBid();
    /**
     * Calculate the median winning bid in the auction.
     * @return median amongst all recorded winning bids.
     */
    int getMedianWinningBid();
}
