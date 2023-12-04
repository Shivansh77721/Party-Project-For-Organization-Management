package com.party.org.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "Party")
@AllArgsConstructor
@NoArgsConstructor
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partyId;

    @Column(name = "first_Name", nullable = false)
    @NotBlank(message = "First Name is Required")
    private String firstName;

    @Column(name = "middle_Name", nullable = false)
    private String middleName;

    @Column(name = "last_Name", nullable = false)
    @NotBlank(message = "Last Name is Required")
    private String lastName;

    @Column(name = "Username", nullable = false)
    @NotBlank(message = "Username is Required")
    private String username;

    @Column(name = "City", nullable = false)
    @NotBlank(message = "City is Required")
    private String City;

    @Column(name = "State", nullable = false)
    @NotBlank(message = "State is Required")
    private String State;

    @Column(name = "Address", nullable = false)
    @NotBlank(message = "Address is Required")
    private String Address;

    @Column(name = "Country", nullable = false)
    @NotBlank(message = "Country is Required")
    private String Country;

    @Column(name = "ZipCode", nullable = false)
    @NotBlank(message = "ZipCode is Required")
    private String zipCode;

    @Column(name = "Phone_No", nullable = false)
    @NotBlank(message = "Phone No. Required Must be 10 Digits")
    @Pattern(regexp = "\\d{10}")
    private String phoneNo;

    @Column(name = "Password", nullable = false)
    @NotBlank(message = "Password is Required")
    private String password;

    @Column(name = "Confirm_Password", nullable = false)
    @NotBlank(message = "Confirm Password is Required")
    private String confirmPassword;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnore
//    @JoinColumn(name = "fk_party_orgg", referencedColumnName = "partyId")
    private List<Organization> Org;

//    public List<Organization> getOrganization() {
//        return Org;
//    }
//
//    public void setOrganization(List<Organization> organization) {
//        this.Org = organization;
//    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}



