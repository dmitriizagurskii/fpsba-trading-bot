# Optibot
Optibot is an implementation of a trading bot participating in [first-price sealed-bid](https://en.wikipedia.org/wiki/First-price_sealed-bid_auction) [all-pay](https://en.wikipedia.org/wiki/All-pay_auction) auction. It provides several bidder and strategies implementations.
The solution consists of two submodules:
1. [optibot-strategy](optibot-strategy) contains different strategies and bidder implementations. It can be used as a separate library for injection into your project. For detailed information refer to this [Readme](optibot-strategy/Readme.md).
2. [optibot-webapp](optibot-webapp) contains web-based implementation of the most advanced bidder declared in the strategy module. It can be controlled via REST API and provides an adequate usage example of the strategy module. For detailed information refer to this [Readme](optibot-webapp/Readme.md).

## Tech Stack
- Java 17, Maven
- Tests - JUnit 5, Mockito
- Code coverage - JaCoCo
- Code style - PMD
- Web - Spring Boot
- Web Documentation - Swagger, OpenAPI