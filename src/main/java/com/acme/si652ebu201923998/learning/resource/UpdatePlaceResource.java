package com.acme.si652ebu201923998.learning.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdatePlaceResource {

    private Long id;

    @Size(max = 250)
    private String name;


    private Long altitude ;

    private Long latitude;

    private Long longitude;

    private String heritage ;
}
