package com.lordgasmic.bff.configuration.errorhandling;

import com.lordgasmic.bff.configuration.errorhandling.model.DerpException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.net.URISyntaxException;

@RestControllerAdvice
@Slf4j
public class LordgasmicExceptionHandler {

    @ExceptionHandler(DerpException.class)
    public ResponseEntity<String> derp() throws URISyntaxException {
        return ResponseEntity.status(401).location(new URI("/login")).build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> catchAll(Exception exception) {
        log.error("LGC-: There was a general error", exception);
        return ResponseEntity.status(220)
                             .body(exception);
    }
}
