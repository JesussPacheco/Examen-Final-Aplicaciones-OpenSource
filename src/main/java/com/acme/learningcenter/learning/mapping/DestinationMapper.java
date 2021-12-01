package com.acme.learningcenter.learning.mapping;

import com.acme.learningcenter.learning.domain.model.entity.Destination;
import com.acme.learningcenter.learning.resource.CreateDestinationResource;
import com.acme.learningcenter.learning.resource.DestinationResource;
import com.acme.learningcenter.learning.resource.UpdateDestinationResource;
import com.acme.learningcenter.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class DestinationMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public DestinationResource toResource(Destination model) {
        return mapper.map(model, DestinationResource.class);
    }

    public Page<DestinationResource> modelListToPage(List<Destination> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, DestinationResource.class), pageable, modelList.size());
    }

    public Destination toModel(CreateDestinationResource resource) {
        return mapper.map(resource, Destination.class);
    }

    public Destination toModel(UpdateDestinationResource resource) {
        return mapper.map(resource, Destination.class);
    }
}
