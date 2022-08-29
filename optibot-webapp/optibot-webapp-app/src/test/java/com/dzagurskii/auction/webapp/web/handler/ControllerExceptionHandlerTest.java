package com.dzagurskii.auction.webapp.web.handler;

import com.dzagurskii.auction.bidder.exception.BidderNotInitializedException;
import com.dzagurskii.auction.webapp.api.service.BidderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ControllerExceptionHandlerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BidderService service;

    @Test
    public void handleBidderExceptionTest() throws Exception {
        BidderNotInitializedException exception = new BidderNotInitializedException();
        Mockito.when(service.getNextBid()).thenThrow(exception);
        mockMvc.perform(get("/api/v1/bot/placeBid")
                        .accept(MediaType.ALL))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(
                        """ 
                                { "message": "Impossible to perform operation, builder was not initialized." } 
                                """));
    }
}