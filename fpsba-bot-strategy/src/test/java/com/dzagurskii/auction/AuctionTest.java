package com.dzagurskii.auction;

import com.dzagurskii.auction.bidder.AdvancedStrategyBidder;
import com.dzagurskii.auction.bidder.SingleStrategyBidder;
import com.dzagurskii.auction.strategy.BidStrategyHolder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuctionTest {

    @ParameterizedTest
    @EnumSource(BidStrategyHolder.class)
    public void auctionTest(BidStrategyHolder baselineStrategy) {
        int repeats = 100;
        List<AuctionResult> auctionResults =
                IntStream.range(0, repeats)
                        .parallel()
                        .mapToObj(repeat ->
                                IntStream.range(1, 15).map(i -> i * i * 2).boxed()
                                        .flatMap(cash -> IntStream.range(1, 15).map(i -> i * i * 2)
                                                .mapToObj(quantity -> auctionTest(quantity, cash, baselineStrategy)))
                                        .toList())
                        .flatMap(Collection::stream)
                        .toList();

        long auctionsWon = auctionResults.stream()
                .filter(auctionResult -> {
                    int remainingQuantity = auctionResult.remainingQuantity();
                    int baselineRemainingQuantity = auctionResult.baselineRemainingQuantity();
                    int remainingCash = auctionResult.remainingCash();
                    int baselineRemainingCash = auctionResult.baselineRemainingCash();

                    return remainingQuantity > baselineRemainingQuantity
                            || (remainingQuantity == baselineRemainingQuantity
                            && remainingCash >= baselineRemainingCash);
                }).count();

        assertTrue(auctionsWon / (double) auctionResults.size() > 0.75);
    }

    private AuctionResult auctionTest(int quantity, int cash, BidStrategyHolder baselineStrategy) {
        AdvancedStrategyBidder advancedStrategyBidder = new AdvancedStrategyBidder();
        SingleStrategyBidder baselineStrategyBidder = new SingleStrategyBidder(baselineStrategy.getStrategy());

        advancedStrategyBidder.init(quantity, cash);
        baselineStrategyBidder.init(quantity, cash);

        int advancedQuantity = 0;
        int baselineQuantity = 0;

        int advancedCash = cash;
        int baselineCash = cash;

        while (quantity > 0) {
            int advancedBid = advancedStrategyBidder.placeBid();
            int baselineBid = baselineStrategyBidder.placeBid();

            if (advancedBid > baselineBid) {
                advancedQuantity += 2;
            } else if (advancedBid == baselineBid) {
                advancedQuantity++;
                baselineQuantity++;
            } else {
                baselineQuantity += 2;
            }

            advancedStrategyBidder.bids(advancedBid, baselineBid);
            baselineStrategyBidder.bids(advancedBid, baselineBid);

            advancedCash -= advancedBid;
            baselineCash -= baselineBid;

            quantity -= 2;
        }

        return new AuctionResult(advancedQuantity, baselineQuantity, advancedCash, baselineCash);
    }


    private record AuctionResult(
            int remainingQuantity,
            int baselineRemainingQuantity,
            int remainingCash,
            int baselineRemainingCash
    ) {
    }
}
