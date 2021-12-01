package com.acme.si652ebu201923998.learning.domain.service;

import com.acme.si652ebu201923998.learning.domain.model.entity.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DestinationService {
    Destination getById(Long destinationId);
    Destination create(Destination destination);

}
