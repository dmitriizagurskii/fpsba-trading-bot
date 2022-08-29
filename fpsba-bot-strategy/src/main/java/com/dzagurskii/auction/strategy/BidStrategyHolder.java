package com.dzagurskii.auction.strategy;

/**
 * Contains all existing bid strategies.
 * @see BidStrategy
 */
public enum BidStrategyHolder {
    RANDOM_STRATEGY(new RandomBidStrategy()),
    CONSTANT_STRATEGY(new ConstantBidStrategy()),
    ZERO_STRATEGY(new ZeroBidStrategy()),
    AVERAGE_STRATEGY(new AverageBidStrategy()),
    MEDIAN_STRATEGY(new MedianBidStrategy());

    private final BidStrategy strategy;

    BidStrategyHolder(BidStrategy strategy) {
        this.strategy = strategy;
    }

    public BidStrategy getStrategy() {
        return strategy;
    }
}
