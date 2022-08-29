package com.dzagurskii.auction.bidder.history;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for {@link com.dzagurskii.auction.bidder.Bidder} using Lists.
 */
public class ListBidHistory implements BidHistory {
    private final List<List<Integer>> history = new ArrayList<>();

    @Override
    public void addEntry(int own, int other) {
        history.add(List.of(own, other));
    }

    @Override
    public int getOwnBidSum() {
        return history.stream()
                .map(bid -> bid.get(0))
                .reduce(Integer::sum)
                .orElse(0);
    }

    @Override
    public int getOtherBidSum() {
        return history.stream()
                .map(bid -> bid.get(1))
                .reduce(Integer::sum)
                .orElse(0);
    }

    @Override
    public int getQuantitySold() {
        return history.size() * 2;
    }

    @Override
    public Double getAverageWinningBid() {
        return history.stream()
                .mapToInt(round -> Math.max(round.get(0), round.get(1)))
                .average().orElse(1.0);
    }

    @Override
    public int getMedianWinningBid() {
        int[] sortedWinningBids = history.stream()
                .mapToInt(round -> Math.max(round.get(0), round.get(1)))
                .sorted()
                .toArray();
        return sortedWinningBids.length > 0 ? sortedWinningBids[sortedWinningBids.length/2] : 1;
    }
}
