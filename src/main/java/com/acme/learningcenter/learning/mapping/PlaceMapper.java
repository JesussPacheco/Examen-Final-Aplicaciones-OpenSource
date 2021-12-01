package com.acme.learningcenter.learning.mapping;

import com.acme.learningcenter.learning.domain.model.entity.Place;
import com.acme.learningcenter.learning.resource.*;
import com.acme.learningcenter.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PlaceMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public PlaceResource toResource(Place model) {
        return mapper.map(model, PlaceResource.class);
    }

    public Page<PlaceResource> modelListToPage(List<Place> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PlaceResource.class), pageable, modelList.size());
    }

    public Place toModel(CreatePlaceResource resource) {
        return mapper.map(resource, Place.class);
    }

    public Place toModel(UpdatePlaceResource resource) {
        return mapper.map(resource, Place.class);
    }
}
