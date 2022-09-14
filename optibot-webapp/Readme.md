# Optibot Webapp
Simple web application implementing [Bidder](../optibot-strategy/src/main/java/com/dzagurskii/auction/bidder/Bidder.java) interface API. 
For complete specification of the [BidderController](optibot-webapp-app/src/main/java/com/dzagurskii/auction/webapp/web/controller/v1/BidderController.java) refer to [swagger webpage](https://dmitriizagurskii.github.io/optibot).

BidderController uses [BidderService](optibot-webapp-api/src/main/java/com/dzagurskii/auction/webapp/api/service/BidderService.java) which creates and initializes Bidder on init request. The only implementation of BidderService is [AdvancedStrategyBidderService](optibot-webapp-impl/src/main/java/com/dzagurskii/auction/webapp/impl/service/AdvancedStrategyBidderService.java) which uses SingleStrategyBidder with advanced strategy described in the strategy submodule [readme](../optibot-strategy/Readme.md).

## How to run
### Using command line
1. Execute `mvn clean install` in the root module
2. Run the application using following command:
   `java -jar optibot-webapp/optibot-webapp-app/target/optibot-webapp-app-1.0.0.jar`

### Using Docker
1. Execute `mvn clean install` in the root module
2. Use docker-compose command to start the application: `docker-compose up --build`.
   To stop the application use `docker-compose down`.