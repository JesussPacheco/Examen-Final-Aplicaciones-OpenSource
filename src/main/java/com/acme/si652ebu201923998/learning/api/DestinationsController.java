package com.acme.si652ebu201923998.learning.api;
import com.acme.si652ebu201923998.learning.domain.service.DestinationService;
import com.acme.si652ebu201923998.learning.mapping.DestinationMapper;
import com.acme.si652ebu201923998.learning.resource.CreateDestinationResource;
import com.acme.si652ebu201923998.learning.resource.DestinationResource;
import com.acme.si652ebu201923998.learning.resource.UpdateDestinationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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

    @PostMapping
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
