package com.party.org.service.impl;

import com.party.org.entity.Party;
import com.party.org.exception.ResourceNotFoundException;
import com.party.org.repository.PartyRepository;
import com.party.org.service.PartyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyServiceImpl implements PartyService {

    private PartyRepository partyRepository;

    public PartyServiceImpl(PartyRepository partyRepository) {
        super();
        this.partyRepository = partyRepository;
    }
    @Override
    public Party saveParty(Party party) {
        return partyRepository.save(party);
    }

    @Override
    public List<Party> getAllParty() {
        return partyRepository.findAll();
    }

    @Override
    public Party getPartyById(long id) {
        Optional<Party> party = partyRepository.findById(id);
        if (party.isPresent()) {
            return party.get();
        }
        else {
            throw new ResourceNotFoundException("Party", "Id", "firstName", "middleName", "lastName", "username", "city", "state", "address", "country", "zipCode", "phoneNo", "password", "confirmPassword");
        }
//        return partyRepository.findById(id).orElseThrow(() ->
//                new ResourceNotFoundException( "Party", "Id", "firstName", "middleName", "lastName", "username", "city", "state", "address", "country", "zipCode", "phoneNo", "password", "confirmPassword"));


    }

    @Override
    public Party updateParty(Party party, long id) {
        // Check ID
        Party existingParty = partyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Party", "Id", "firstName", "middleName", "lastName", "username", "city", "state", "address", "country", "zipCode", "phoneNo", "password", "confirmPassword"));
        existingParty.setFirstName(party.getFirstName());
        existingParty.setMiddleName(party.getMiddleName());
        existingParty.setLastName(party.getLastName());
        existingParty.setCity(party.getCity());
        existingParty.setState(party.getState());
        existingParty.setAddress(party.getAddress());
        existingParty.setCountry(party.getCountry());
        existingParty.setZipCode(party.getZipCode());
        existingParty.setPhoneNo(party.getPhoneNo());
        existingParty.setPassword(party.getPassword());
        existingParty.setConfirmPassword(party.getConfirmPassword());
            // Save Existing Party to DB
        partyRepository.save(existingParty);
        return existingParty;
    }

    @Override
    public void deleteParty(long id) {
        partyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Party", "Id", "firstName", "middleName", "lastName", "username", "city", "state", "address", "country", "zipCode", "phoneNo", "password", "confirmPassword"));
        partyRepository.deleteById(id);
    }
}
