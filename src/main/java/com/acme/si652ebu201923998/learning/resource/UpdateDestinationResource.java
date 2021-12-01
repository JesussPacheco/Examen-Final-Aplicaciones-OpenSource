package com.acme.si652ebu201923998.learning.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateDestinationResource {

    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 250)
    private String city;

    @NotNull
    @Size(max = 250)
    private String country;

    @Size(max = 250)
    private String photoUrl;

}
