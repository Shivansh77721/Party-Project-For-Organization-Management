//package com.party.org;
//
//import com.party.org.entity.Organization;
//import com.party.org.entity.Party;
//import com.party.org.repository.OrganizationRepository;
//import com.party.org.repository.PartyRepository;
//import org.hibernate.annotations.Comments;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.stereotype.Component;
//
//@Component
//@SpringBootApplication
//public class PartyOrgEntityMappingApp implements CommandLineRunner {
//    @Autowired
//    private PartyRepository partyRepository;
//    @Autowired
//    private OrganizationRepository organizationRepository;
//    private Organization organization;
//
//    public static void main(String[] args) {
//        SpringApplication.run(PartyOrgEntityMappingApp.class);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Shivansh");
//
//        Party party = new Party();
//
//        Organization organization = new Organization("organization");
////        Organization organization2 = new Organization("organization2");
////        Organization organization3 = new Organization("organization3");
////        Organization organization4 = new Organization("organization4");
////        Organization organization5 = new Organization("organization5");
////        Organization organization6 = new Organization("organization6");
////
//        party.getOrganization().add(organization);
////        party.getOrganization().add(organization2);
////        party.getOrganization().add(organization3);
////        party.getOrganization().add(organization4);
////        party.getOrganization().add(organization5);
////        party.getOrganization().add(organization6);
//
//        partyRepository.save(party);
//
//    }
//}
