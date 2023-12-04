package com.party.org.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionOrg extends RuntimeException {

    private long getId;
    private String OrganizationName;
    private String organizationWork;

    public ResourceNotFoundExceptionOrg(String getId, String organizationName, String organizationWork) {
        super(String.format("%s not found with %s : '%s'", getId, organizationName, organizationWork));
        this.getId = Long.parseLong(getId);
        OrganizationName = organizationName;
        this.organizationWork = organizationWork;
    }

    public long getGetId() {
        return getId;
    }

    public void setGetId(long getId) {
        this.getId = getId;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        OrganizationName = organizationName;
    }

    public String getOrganizationWork() {
        return organizationWork;
    }

    public void setOrganizationWork(String organizationWork) {
        this.organizationWork = organizationWork;
    }


}
