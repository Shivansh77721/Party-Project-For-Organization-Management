package com.party.org.repository;

import com.party.org.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartyRepository extends JpaRepository<Party, Long> {
    Optional<Party> findByUsername(String username);

    boolean existsByUsername(String username);
}
