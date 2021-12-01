package com.acme.si652ebu201923998.learning.domain.model.entity;

import com.acme.si652ebu201923998.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "places")
public class Place extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 250)
    private String name;


    private Long altitude ;

    private Long latitude;

    private Long longitude;

    private String heritage ;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

}
