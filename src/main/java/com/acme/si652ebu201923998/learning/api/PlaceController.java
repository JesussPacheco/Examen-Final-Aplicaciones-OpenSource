package com.acme.si652ebu201923998.learning.api;

import com.acme.si652ebu201923998.learning.domain.service.PlaceService;
import com.acme.si652ebu201923998.learning.mapping.PlaceMapper;
import com.acme.si652ebu201923998.learning.resource.PlaceResource;
import com.acme.si652ebu201923998.learning.resource.CreatePlaceResource;
import com.acme.si652ebu201923998.learning.resource.UpdatePlaceResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/destinations/{destinationId}/places")
public class PlaceController {

    private final PlaceService placeService;

    private final PlaceMapper mapper;

    public PlaceController(PlaceService placeService, PlaceMapper mapper) {
        this.placeService = placeService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<PlaceResource> getAllPlacesByDestinationId(@PathVariable Long destinationId, Pageable pageable) {
        return mapper.modelListToPage(placeService.getAllByDestinationId(destinationId), pageable);
    }

    @PostMapping
    public PlaceResource createPlace(@PathVariable Long destinationId,
                                         @RequestBody CreatePlaceResource request) {
        return mapper.toResource(placeService.create(destinationId, mapper.toModel(request)));
    }


    @PutMapping("{placeId}")
    public PlaceResource updatePlace(@PathVariable Long destinationId,
                                         @PathVariable Long placeId,
                                         @RequestBody UpdatePlaceResource request) {
        return mapper.toResource(placeService.update(destinationId, placeId, mapper.toModel(request)));
    }
    @GetMapping("{placeId}")
    public PlaceResource getPlaceById(@PathVariable("destinationId") Long destinationId,
            @PathVariable("placeId") Long placeId) {
        return mapper.toResource(placeService.getByIdAndDestinationId(destinationId, placeId));
    }


    @DeleteMapping("{placeId}")
    public ResponseEntity<?> deletePlace(@PathVariable Long destinationId,
                                           @PathVariable Long placeId) {
        return placeService.delete(destinationId, placeId);
    }
}
