package com.dzagurskii.auction.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuctionBotApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AuctionBotApplication.class);
        springApplication.run(args);
    }
}
