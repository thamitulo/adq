package com.ae.adq.maha.interview.rest;

//import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    @PostMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkout(@RequestBody List<String> watchIDs) {
        return ResponseEntity.ok("Ok");
    }
}
