# Optibot Strategy

## Bidder

Optibot uses [Bidder](src/main/java/com/dzagurskii/auction/bidder/Bidder.java) as a main interface for participants of
the auction. There is a main implementation of the Bidder interface: [SingleStrategyBidder](src/main/java/com/dzagurskii/auction/bidder/SingleStrategyBidder.java).

SingleStrategyBidder requires strategy to be passed as a constructor parameter. If not set it uses random bid strategy.

## Strategy

All strategies implement [BidStrategy](src/main/java/com/dzagurskii/auction/strategy/BidStrategy.java) interface. There
are 6 bid strategies implemented:

1. Zero bid strategy - place 0 bid regardless of conditions.
2. Random bid strategy - place random bid bounded by the remaining cash.
3. Constant bid strategy - place bid by calculating remaining cash divided by remaining rounds.
4. Median bid strategy - find the median amongst all recorded winning bids.
5. Average bid strategy - find the average amongst all recorded winning bids.
6. Advanced bid strategy - if bidder's quantity or remaining cash is greater than opponent's then use average bid strategy. Use random bid strategy otherwise.

Since the strategies are stateless they are instantiated in [BidStrategyHolder](src/main/java/com/dzagurskii/auction/strategy/BidStrategyHolder.java).

All bids are normalized in [StrategyBidder](src/main/java/com/dzagurskii/auction/bidder/StrategyBidder.java), if the
calculated bid is more than remaining cash, then remaining cash amount is returned.

## Usage

In order to use strategy module as a library it is necessary to build it using Maven.
Run command ```mvn clean install```.
After that it is possible to add the module as a dependency.
```xml
<dependency>
    <groupId>com.dzagurskii.auction</groupId>
    <artifactId>optibot-strategy</artifactId>
    <version>1.0.0</version>
</dependency>
```

In order to use SingleStrategyBidder with advanced strategy simply create it using constructor.
```java
Bidder bidder = new SingleStrategyBidder(BidStrategyHolder.ADVANCED_STRATEGY.getStrategy());
```
