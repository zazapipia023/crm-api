package org.colizeum.crmapi.repository;

import org.colizeum.crmapi.model.Ubisoft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UbisoftRepository extends JpaRepository<Ubisoft, Long> {

    Optional<Ubisoft> findByName(String name);

    void deleteByName(String name);

}