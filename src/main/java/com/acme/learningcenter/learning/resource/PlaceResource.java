package com.acme.learningcenter.learning.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class PlaceResource {
    @Size(max = 250)
    private String name;


    private Long altitude ;

    private Long latitude;

    private Long longitude;

    private String heritage ;
}
