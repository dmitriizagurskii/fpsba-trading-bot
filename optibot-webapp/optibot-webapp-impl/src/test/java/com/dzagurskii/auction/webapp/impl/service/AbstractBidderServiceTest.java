package com.dzagurskii.auction.webapp.impl.service;

import com.dzagurskii.auction.bidder.Bidder;
import com.dzagurskii.auction.bidder.exception.BidderNotInitializedException;
import com.dzagurskii.auction.webapp.api.model.BidderInitializationRequest;
import com.dzagurskii.auction.webapp.api.model.SaveBidsRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AbstractBidderServiceTest {

    private AbstractBidderService bidderService;

    @BeforeEach
    public void init() {
        this.bidderService = Mockito.mock(
                AbstractBidderService.class,
                Mockito.CALLS_REAL_METHODS);
        Mockito.when(bidderService.createBidder()).thenReturn(Mockito.spy(Bidder.class));
    }

    @Test
    public void bidderFlowTest() {
        BidderInitializationRequest bidderInitializationRequest = getBidderInitializationRequest();
        bidderService.initializeBidder(bidderInitializationRequest);

        Integer nextBid = bidderService.getNextBid();
        assertNotNull(nextBid);

        SaveBidsRequest saveBidsRequest = getSaveBidsRequest(nextBid);
        bidderService.saveBids(saveBidsRequest);
    }

    private static BidderInitializationRequest getBidderInitializationRequest() {
        BidderInitializationRequest bidderInitializationRequest = new BidderInitializationRequest();
        bidderInitializationRequest.setCash(10);
        bidderInitializationRequest.setQuantity(10);
        return bidderInitializationRequest;
    }

    private static SaveBidsRequest getSaveBidsRequest(Integer nextBid) {
        SaveBidsRequest saveBidsRequest = new SaveBidsRequest();
        saveBidsRequest.setOwn(nextBid);
        saveBidsRequest.setOther(10);
        return saveBidsRequest;
    }

    @Test
    public void getNextBid_whenBidderNotInitialized_thenException() {
        assertThrows(BidderNotInitializedException.class, () -> bidderService.getNextBid());
    }

    @Test
    public void saveBids_whenBidderNotInitialized_thenException() {
        assertThrows(BidderNotInitializedException.class, () -> bidderService.saveBids(null));
    }
}