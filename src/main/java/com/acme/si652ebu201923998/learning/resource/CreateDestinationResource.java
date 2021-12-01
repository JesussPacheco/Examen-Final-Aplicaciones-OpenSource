package com.acme.si652ebu201923998.learning.resource;

import lombok.Getter;
import lombok.Setter;

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
