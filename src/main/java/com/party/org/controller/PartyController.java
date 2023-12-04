package com.party.org.controller;


import com.party.org.entity.Party;
import com.party.org.service.PartyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/party")
public class PartyController {

    private PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    // Create Data for Rest API
    @PostMapping()
    public ResponseEntity<Party> saveParty(@RequestBody Party party) {
        return new ResponseEntity<Party>(partyService.saveParty(party), HttpStatus.CREATED);
    }

    // Read All Party Data Rest API
    @GetMapping
    public List<Party> getAllParty(){
        return partyService.getAllParty();
    }

    // Read Party Data by ID
    @GetMapping("{id}")
    public ResponseEntity<Party> getPartyById(@PathVariable("id") long partyId) {
        return new ResponseEntity<Party>(partyService.getPartyById(partyId), HttpStatus.OK);
    }

    // Update Party Data IDBy Rest API
    @PutMapping("{id}")
    public ResponseEntity<Party> updateParty(@PathVariable("id") long id, @RequestBody Party party){
        return new ResponseEntity<Party>(partyService.updateParty(party, id), HttpStatus.OK);
    }

    // Delete Party Data ID Rest API
    @DeleteMapping("{id}")
    public ResponseEntity deleteParty(@PathVariable("id") long id) {
        // Delete Emp by DB
        partyService.deleteParty(id);
        return new ResponseEntity("Party Deleted Successfully!.", HttpStatus.OK);
    }
}