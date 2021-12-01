package com.acme.si652ebu201923998.learning.service;

import com.acme.si652ebu201923998.learning.domain.model.entity.Destination;
import com.acme.si652ebu201923998.learning.domain.persistence.DestinationRepository;
import com.acme.si652ebu201923998.learning.domain.service.DestinationService;
import com.acme.si652ebu201923998.shared.exception.ResourceNotFoundException;
import com.acme.si652ebu201923998.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class DestinationServiceImpl implements DestinationService {

    private static final String ENTITY = "Destination";

    private final DestinationRepository destinationRepository;

    private final Validator validator;

    public DestinationServiceImpl(DestinationRepository destinationRepository, Validator validator) {
        this.destinationRepository = destinationRepository;
        this.validator = validator;
    }


    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }


    @Override
    public Destination getById(Long destinationId) {
        return destinationRepository.findById(destinationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, destinationId));
    }

    @Override
    public Destination create(Destination request) {
        Set<ConstraintViolation<Destination>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return destinationRepository.save(request);
    }


}
