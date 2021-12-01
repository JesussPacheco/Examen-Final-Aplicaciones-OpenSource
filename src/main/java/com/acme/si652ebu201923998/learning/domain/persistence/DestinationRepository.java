package com.acme.si652ebu201923998.learning.domain.persistence;

import com.acme.si652ebu201923998.learning.domain.model.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
