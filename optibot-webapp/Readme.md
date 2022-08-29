# Optibot Webapp
Simple web application implementing [Bidder](../optibot-strategy/src/main/java/com/dzagurskii/auction/bidder/Bidder.java) interface API. 
For complete specification of the [BidderController](optibot-webapp-app/src/main/java/com/dzagurskii/auction/webapp/web/controller/v1/BidderController.java) refer to [swagger webpage](https://dmitriizagurskii.github.io/optibot).

BidderController uses [BidderService](optibot-webapp-api/src/main/java/com/dzagurskii/auction/webapp/api/service/BidderService.java) which creates and initializes Bidder on init request. The only implementation of BidderService is [AdvancedStrategyBidderService](optibot-webapp-impl/src/main/java/com/dzagurskii/auction/webapp/impl/service/AdvancedStrategyBidderService.java) which uses AdvancedStrategyBidder described in strategy submodule [readme](../optibot-strategy/Readme.md).
