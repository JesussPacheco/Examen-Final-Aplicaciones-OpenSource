package com.acme.si652ebu201923998.learning.domain.persistence;

import com.acme.si652ebu201923998.learning.domain.model.entity.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByDestinationId(Long destinationId);
    Page<Place> findByDestinationId(Long destinationId, Pageable pageable);
    Optional<Place> findByIdAndDestinationId(Long id, Long destinationId);
}
