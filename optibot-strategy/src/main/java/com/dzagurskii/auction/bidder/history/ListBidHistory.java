package com.dzagurskii.auction.bidder.history;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for {@link com.dzagurskii.auction.bidder.Bidder} using Lists.
 */
public class ListBidHistory implements BidHistory {
    private final List<BidEntry> history = new ArrayList<>();

    @Override
    public void addEntry(int own, int other) {
        history.add(new BidEntry(own, other));
    }

    @Override
    public int getOwnBidSum() {
        return history.stream()
                .mapToInt(BidEntry::own)
                .sum();
    }

    @Override
    public int getOtherBidSum() {
        return history.stream()
                .mapToInt(BidEntry::other)
                .sum();
    }

    @Override
    public int getQuantitySold() {
        return history.size() * 2;
    }

    @Override
    public double getAverageWinningBid() {
        return history.stream()
                .mapToInt(round -> Math.max(round.own(), round.other()))
                .average().orElse(0.0);
    }

    @Override
    public int getMedianWinningBid() {
        int[] sortedWinningBids = history.stream()
                .mapToInt(round -> Math.max(round.own(), round.other()))
                .sorted()
                .toArray();
        return sortedWinningBids.length > 0 ? sortedWinningBids[sortedWinningBids.length/2] : 1;
    }
}
