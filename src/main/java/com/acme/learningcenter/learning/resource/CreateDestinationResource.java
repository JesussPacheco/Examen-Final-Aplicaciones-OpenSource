package com.acme.learningcenter.learning.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateDestinationResource {

    @Size(max = 100)
    private String name;


    @Size(max = 250)
    private String city;

    @Size(max = 250)
    private String country;

    @Size(max = 250)
    private String photoUrl;


}
