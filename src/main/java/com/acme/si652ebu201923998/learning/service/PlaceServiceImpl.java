package com.acme.si652ebu201923998.learning.service;

import com.acme.si652ebu201923998.learning.domain.model.entity.Place;
import com.acme.si652ebu201923998.learning.domain.persistence.PlaceRepository;
import com.acme.si652ebu201923998.learning.domain.persistence.DestinationRepository;
import com.acme.si652ebu201923998.learning.domain.service.PlaceService;
import com.acme.si652ebu201923998.shared.exception.ResourceNotFoundException;
import com.acme.si652ebu201923998.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PlaceServiceImpl implements PlaceService {

    private static final String ENTITY = "Place";

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private Validator validator;



    @Override
    public Place create(Long destinationId, Place request) {
        Set<ConstraintViolation<Place>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return destinationRepository.findById(destinationId).map(destination -> {
                request.setDestination(destination);
                return placeRepository.save(request);
            }).orElseThrow(() -> new ResourceNotFoundException("Destination", destinationId ));
    }

    @Override
    public Place update(Long destinationId, Long placeId, Place request) {

        Set<ConstraintViolation<Place>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!destinationRepository.existsById(destinationId))
            throw new ResourceNotFoundException("Destination", destinationId);

        return placeRepository.findById(placeId).map(place ->
                placeRepository.save(place.withName(request.getName()))
                        .withAltitude(request.getAltitude())
                        .withLatitude(request.getLatitude())
                        .withLongitude(request.getLongitude())
                        .withHeritage(request.getHeritage())
           ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, placeId));

    }



    @Override
    public Place getByIdAndDestinationId(Long destinationId, Long placeId) {
        return placeRepository.findByIdAndDestinationId(placeId, destinationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, placeId));
    }
}
