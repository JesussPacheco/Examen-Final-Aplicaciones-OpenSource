package com.acme.learningcenter.learning.service;

import com.acme.learningcenter.learning.domain.model.entity.Comment;
import com.acme.learningcenter.learning.domain.persistence.CommentRepository;
import com.acme.learningcenter.learning.domain.persistence.DestinationRepository;
import com.acme.learningcenter.learning.domain.service.CommentService;
import com.acme.learningcenter.shared.exception.ResourceNotFoundException;
import com.acme.learningcenter.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

    private static final String ENTITY = "Comment";

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Comment> getAllByDestinationId(Long destinationId) {
        return commentRepository.findByDestinationId(destinationId);
    }

    @Override
    public Page<Comment> getAllByDestinationId(Long destinationId, Pageable pageable) {
        return commentRepository.findByDestinationId(destinationId, pageable);
    }

    @Override
    public Comment create(Long destinationId, Comment request) {
        Set<ConstraintViolation<Comment>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return destinationRepository.findById(destinationId).map(destination -> {
                request.setDestination(destination);
                return commentRepository.save(request);
            }).orElseThrow(() -> new ResourceNotFoundException("Destination", destinationId ));
    }

    @Override
    public Comment update(Long destinationId, Long commentId, Comment request) {

        Set<ConstraintViolation<Comment>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!destinationRepository.existsById(destinationId))
            throw new ResourceNotFoundException("Destination", destinationId);

        return commentRepository.findById(commentId).map(comment ->
                commentRepository.save(comment.withText(request.getText()))
           ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));

    }

    @Override
    public ResponseEntity<?> delete(Long destinationId, Long commentId) {

        return commentRepository.findByIdAndDestinationId(commentId, destinationId).map(comment -> {
                commentRepository.delete(comment);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));

    }

    @Override
    public Comment getByIdAndDestinationId(Long destinationId, Long commentId) {
        return commentRepository.findByIdAndDestinationId(commentId, destinationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }
}
