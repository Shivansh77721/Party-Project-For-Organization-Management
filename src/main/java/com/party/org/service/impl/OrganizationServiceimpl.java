package com.party.org.service.impl;

import com.party.org.entity.Organization;
import com.party.org.entity.Party;
import com.party.org.exception.ResourceNotFoundExceptionOrg;
import com.party.org.repository.OrganizationRepository;
import com.party.org.repository.PartyRepository;
import com.party.org.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;


@Service
public class OrganizationServiceimpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private PartyRepository partyRepository;

    public OrganizationServiceimpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization saveOrganization(Organization organization,Long partyId) {
        Party party = this.partyRepository.findById(partyId).orElseThrow(null);
        organization.setParty(party);
        return organizationRepository.save(organization);
    }

    @Override
    public List<Organization> getAllOrganization() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getOrganizationById(long id) {
//        Optional<Organization> organization = organizationRepository.findById(id);
//        if (organization.isPresent()) {
//            return organization.get();
//        }
//        else {
//            throw new ResourceNotFoundExceptionOrg("getId", "organizationName", "organizationWork");
//        }
        return organizationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundExceptionOrg("getId", "organizationName", "organizationWork"));
    }

    @Override
    public Organization updateOrganizationById(Organization organization, long id) {
//         we need to check wheather employee with given is is exist in DB or Not
        Organization existingOrganization = organizationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundExceptionOrg("getId", "organizationName", "organizationWork"));
        existingOrganization.setOrganizationName(organization.getOrganizationName());
        existingOrganization.setOrganizationWork(organization.getOrganizationWork());
//        save existing Organization to DB
        organizationRepository.save(existingOrganization);
        return existingOrganization;
    }

    @Override
    public void deleteOrganization(long id) {
//        Check wheather a Organization exist in a DB or Not
        organizationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundExceptionOrg("getId", "organizationName", "organizationWork"));
        organizationRepository.deleteById(id);
    }
}
