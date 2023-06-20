package org.example.controller;

import org.example.data.CardEntity;
import org.example.service.BinFinderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/binFinder")
public class BinFinderController {
    public BinFinderController(BinFinderService binFinderService) {
        this.binFinderService = binFinderService;
    }

    BinFinderService binFinderService;

    @GetMapping(path = "/{cardNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CardEntity binFinder(@PathVariable int cardNum) {
        return binFinderService.findCard(cardNum);

    }

}