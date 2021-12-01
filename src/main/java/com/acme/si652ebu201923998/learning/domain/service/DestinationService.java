package com.acme.si652ebu201923998.learning.domain.service;

import com.acme.si652ebu201923998.learning.domain.model.entity.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DestinationService {
    List<Destination> getAll();
    Page<Destination> getAll(Pageable pageable);
    Destination getById(Long destinationId);
    Destination create(Destination destination);
    Destination update(Long destinationId, Destination request);
    ResponseEntity<?> delete(Long destinationId);
}
