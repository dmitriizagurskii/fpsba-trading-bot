package com.dzagurskii.auction.webapp.web.controller.v1;

import com.dzagurskii.auction.webapp.api.model.BidderInitializationRequest;
import com.dzagurskii.auction.webapp.api.model.SaveBidsRequest;
import com.dzagurskii.auction.webapp.api.service.BidderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bot")
public class BidderController {

    @Autowired
    private BidderService bidderService;

    @Operation(summary = "Create bidder by setting initial state")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bidder was successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid action for bidder",
                    content = @Content)})
    @PostMapping("/init")
    public void init(@RequestBody BidderInitializationRequest initializationRequest) {
        bidderService.initializeBidder(initializationRequest);
    }

    @Operation(summary = "Get next bid calculated by the bidder")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bidder successfully calculated next bid",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid action for bidder",
                    content = @Content)})
    @GetMapping("/placeBid")
    public Integer getNextBid() {
        return bidderService.getNextBid();
    }

    @Operation(summary = "Update bidder with latest bids information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bidder was successfully updated"),
            @ApiResponse(responseCode = "400", description = "Invalid action for bidder",
                    content = @Content)})
    @PostMapping("/bids")
    public void saveBids(@RequestBody SaveBidsRequest bidsRequest) {
        bidderService.saveBids(bidsRequest);
    }
}
