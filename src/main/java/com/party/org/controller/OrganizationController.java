package com.party.org.controller;


import com.party.org.entity.Organization;
import com.party.org.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/org")
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    // Create Rest API For Data Save
    @PostMapping("/addOrg/{partyId}")
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization, @PathVariable Long partyId) {
        return new ResponseEntity<Organization>(organizationService.saveOrganization(organization,partyId), HttpStatus.CREATED);
    }

    // Read All Org Data
    @GetMapping
    public List<Organization> getAllOrganization(){
        return organizationService.getAllOrganization();
    }

//    Read Organization Data By ID
    @GetMapping("{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable("id") long organizationId){
        return new ResponseEntity<Organization>(organizationService.getOrganizationById(organizationId), HttpStatus.OK);
    }

//    Update Organization Data By Id
    @PutMapping("{id}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable("id") long id, @RequestBody Organization organization) {
        return new ResponseEntity<Organization>(organizationService.updateOrganizationById(organization, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteOrganization(@PathVariable("id") long id) {
//         Delete Org From DB
        organizationService.deleteOrganization(id);
        return new ResponseEntity("Organization Data Deleted Successfully!!", HttpStatus.OK);
    }
}
