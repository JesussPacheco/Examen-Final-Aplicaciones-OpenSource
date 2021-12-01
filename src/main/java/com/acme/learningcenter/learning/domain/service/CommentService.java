package com.acme.learningcenter.learning.domain.service;

import com.acme.learningcenter.learning.domain.model.entity.Comment;
import com.acme.learningcenter.learning.domain.model.entity.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    List<Comment> getAllByDestinationId(Long destinationId);
    Page<Comment> getAllByDestinationId(Long destinationId, Pageable pageable);
    Comment create(Long destinationId, Comment request);
    Comment update(Long destinationId, Long commentId, Comment request);
    ResponseEntity<?> delete(Long destinationId, Long commentId);

    Comment getByIdAndDestinationId(Long destinationId, Long commentId);
}
