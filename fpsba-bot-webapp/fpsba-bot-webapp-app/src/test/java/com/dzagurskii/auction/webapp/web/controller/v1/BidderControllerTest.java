package com.dzagurskii.auction.webapp.web.controller.v1;

import com.dzagurskii.auction.webapp.api.service.BidderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BidderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BidderService service;

    @Test
    public void initTest() throws Exception {
        mockMvc.perform(post("/api/v1/bot/init")
                        .content("""
                                {
                                    "cash": 10,
                                    "quantity": 10
                                }
                                """)
                        .header("content-type", MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL))
                .andExpect(status().isOk());
    }

    @Test
    public void getNextBidTest() throws Exception {
        Mockito.when(service.getNextBid()).thenReturn(10);
        mockMvc.perform(get("/api/v1/bot/placeBid")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().json("10"));
    }

    @Test
    public void saveBidsTest() throws Exception {
        mockMvc.perform(post("/api/v1/bot/bids")
                        .content("""
                                {
                                    "own": 10,
                                    "other": 10
                                }
                                """)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL))
                .andExpect(status().isOk());
    }
}