package org.colizeum.crmapi.repository;

import org.colizeum.crmapi.model.VkPlay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VkPlayRepository extends JpaRepository<VkPlay, Long> {

    Optional<VkPlay> findByName(String name);

    void deleteByName(String name);

}