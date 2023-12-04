package com.party.org.service;

import com.party.org.entity.Party;

import java.util.List;

public interface PartyService  {
    Party saveParty(Party party);
    List<Party> getAllParty();
    Party getPartyById(long id);
    Party updateParty(Party party, long id);
    void deleteParty(long id);
}
