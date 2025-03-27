package org.colizeum.crmapi.repository;

import org.colizeum.crmapi.model.Steam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SteamRepository extends JpaRepository<Steam, Long> {

    Optional<Steam> findByName(String name);

    void deleteByName(String name);

}