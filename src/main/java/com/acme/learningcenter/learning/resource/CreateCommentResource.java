package com.acme.learningcenter.learning.resource;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class CreateCommentResource {
    @NotNull
    private String text;
}
