package com.acme.learningcenter.learning.domain.service;

import com.acme.learningcenter.learning.domain.model.entity.Place;
import com.acme.learningcenter.learning.domain.model.entity.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlaceService {
    List<Place> getAllByDestinationId(Long destinationId);
    Page<Place> getAllByDestinationId(Long destinationId, Pageable pageable);
    Place create(Long destinationId, Place request);
    Place update(Long destinationId, Long placeId, Place request);
    ResponseEntity<?> delete(Long destinationId, Long placeId);

    Place getByIdAndDestinationId(Long destinationId, Long placeId);
}
