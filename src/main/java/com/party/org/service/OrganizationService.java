package com.party.org.service;

import com.party.org.entity.Organization;

import java.util.List;

public interface OrganizationService {
    Organization saveOrganization(Organization organization,Long partyId);
    List<Organization> getAllOrganization();
    Organization getOrganizationById(long id);
    Organization updateOrganizationById(Organization organization, long id);
    void deleteOrganization(long id);
}
