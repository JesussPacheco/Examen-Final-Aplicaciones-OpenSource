package com.acme.si652ebu201923998.learning.domain.service;

import com.acme.si652ebu201923998.learning.domain.model.entity.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlaceService {
    Place create(Long destinationId, Place request);
    Place update(Long destinationId, Long placeId, Place request);
    Place getByIdAndDestinationId(Long destinationId, Long placeId);
}
