package com.party.org.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "Org")
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_Id")
    private long orgId;

//    @Column(name = "partyId")
//    private long partyId;

//    @Column(name = "Date")
//    private Date currentDate;

    @Column(name = "organization_Name", nullable = false)
    @NotBlank(message = "Organation Name is Required")
    private String organizationName;

    @Column(name = "organization_Work", nullable = false)
    @NotBlank(message = "Organization Name is Required")
    private String organizationWork;
    @ManyToOne
    private Party party;

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

//    public long getPartyId() {
//        return partyId;
//    }
//
//    public void setPartyId(long partyId) {
//        this.partyId = partyId;
//    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationWork() {
        return organizationWork;
    }

    public void setOrganizationWork(String organizationWork) {
        this.organizationWork = organizationWork;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}