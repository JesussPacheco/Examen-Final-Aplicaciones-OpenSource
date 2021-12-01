package com.acme.learningcenter.learning.domain.persistence;

import com.acme.learningcenter.learning.domain.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByDestinationId(Long destinationId);
    Page<Comment> findByDestinationId(Long destinationId, Pageable pageable);
    Optional<Comment> findByIdAndDestinationId(Long id, Long destinationId);
}
