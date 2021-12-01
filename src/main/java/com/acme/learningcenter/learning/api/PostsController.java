package com.acme.learningcenter.learning.api;

import com.acme.learningcenter.learning.domain.service.DestinationService;
import com.acme.learningcenter.learning.mapping.DestinationMapper;
import com.acme.learningcenter.learning.resource.CreateDestinationResource;
import com.acme.learningcenter.learning.resource.DestinationResource;
import com.acme.learningcenter.learning.resource.UpdateDestinationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/destinations")
public class DestinationsController {

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private DestinationMapper mapper;

    @GetMapping
    public Page<DestinationResource> getAllDestinations(Pageable pageable) {
        return mapper.modelListToPage(destinationService.getAll(), pageable);
    }

    @GetMapping("{destinationId}")
    public DestinationResource getDestinationById(@PathVariable("destinationId") Long destinationId) {
        return mapper.toResource(destinationService.getById(destinationId));
    }

    @DestinationMapping
    public DestinationResource createDestination(@RequestBody CreateDestinationResource request) {

        return mapper.toResource(destinationService.create(mapper.toModel(request)));
    }

    @PutMapping("{destinationId}")
    public DestinationResource updateDestination(@PathVariable Long destinationId, @RequestBody UpdateDestinationResource request) {
        return mapper.toResource(destinationService.update(destinationId, mapper.toModel(request)));
    }

    @DeleteMapping("{destinationId}")
    public ResponseEntity<?> deleteDestination(@PathVariable Long destinationId) {
        return destinationService.delete(destinationId);
    }



}
