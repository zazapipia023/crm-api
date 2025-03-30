package org.colizeum.crmapi.repository;

import org.colizeum.crmapi.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {

    Optional<Guide> findByTitle(String title);

    void deleteByTitle(String title);

}
