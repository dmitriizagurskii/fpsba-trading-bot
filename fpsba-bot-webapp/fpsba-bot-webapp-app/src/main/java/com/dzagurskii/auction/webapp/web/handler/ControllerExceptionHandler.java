package com.dzagurskii.auction.webapp.web.handler;

import com.dzagurskii.auction.bidder.exception.BidderException;
import com.dzagurskii.auction.webapp.web.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(BidderException exception) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(exception.getMessage()));
    }
}
