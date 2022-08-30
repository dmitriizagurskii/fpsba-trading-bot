# Optibot
Optibot is an implementation of a trading bot participating in [first-price sealed-bid](https://en.wikipedia.org/wiki/First-price_sealed-bid_auction) [all-pay](https://en.wikipedia.org/wiki/All-pay_auction) auction. 
It provides several bidder and strategies implementations.
The solution consists of two submodules:
1. [optibot-strategy](optibot-strategy) contains different strategies and bidder implementations. It can be used as a separate library for injection into your project. For detailed information please refer to following [readme](optibot-strategy/Readme.md).
2. [optibot-webapp](optibot-webapp) contains web-based implementation of the most advanced bidder declared in the strategy module. It can be controlled via REST API and provides an adequate usage example of the strategy module. For detailed information please refer to following [readme](optibot-webapp/Readme.md).

## Tech Stack
- Java 17, Maven
- Tests - JUnit 5, Mockito
- Code coverage - JaCoCo
- Code style - PMD
- Web - Spring Boot
- Web Documentation - Swagger, OpenAPI

## How to run
### Using command line 
Execute `mvn clean install` in the root module, then run the application using following command:
`java -jar optibot-webapp/optibot-webapp-app/target/optibot-webapp-app-1.0.0.jar`

### Using Docker
1. Execute `mvn clean install` in the root module
2. Use docker-compose command: `docker-compose up`
To stop the application use `docker-compose down`.