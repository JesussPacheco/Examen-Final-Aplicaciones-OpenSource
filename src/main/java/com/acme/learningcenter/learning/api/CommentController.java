package com.acme.learningcenter.learning.api;

import com.acme.learningcenter.learning.domain.service.CommentService;
import com.acme.learningcenter.learning.domain.service.DestinationService;
import com.acme.learningcenter.learning.mapping.CommentMapper;
import com.acme.learningcenter.learning.resource.CommentResource;
import com.acme.learningcenter.learning.resource.CreateCommentResource;
import com.acme.learningcenter.learning.resource.UpdateCommentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/destinations/{destinationId}/comments")
public class CommentController {

    private final CommentService commentService;

    private final CommentMapper mapper;

    public CommentController(CommentService commentService, CommentMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<CommentResource> getAllCommentsByDestinationId(@PathVariable Long destinationId, Pageable pageable) {
        return mapper.modelListToPage(commentService.getAllByDestinationId(destinationId), pageable);
    }

    @PostMapping
    public CommentResource createComment(@PathVariable Long destinationId,
                                         @RequestBody CreateCommentResource request) {
        return mapper.toResource(commentService.create(destinationId, mapper.toModel(request)));
    }


    @PutMapping("{commentId}")
    public CommentResource updateComment(@PathVariable Long destinationId,
                                         @PathVariable Long commentId,
                                         @RequestBody UpdateCommentResource request) {
        return mapper.toResource(commentService.update(destinationId, commentId, mapper.toModel(request)));
    }
    @GetMapping("{commentId}")
    public CommentResource getCommentById(@PathVariable("destinationId") Long destinationId,
            @PathVariable("commentId") Long commentId) {
        return mapper.toResource(commentService.getByIdAndDestinationId(destinationId, commentId));
    }


    @DeleteMapping("{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long destinationId,
                                           @PathVariable Long commentId) {
        return commentService.delete(destinationId, commentId);
    }
}
