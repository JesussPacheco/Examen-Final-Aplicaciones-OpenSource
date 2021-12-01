package com.acme.si652ebu201923998.learning.domain.model.entity;

import com.acme.si652ebu201923998.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "destinations")
public class Destination extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(max = 100)
    @Column(unique = true)
    private String name;


    @Size(max = 250)
    private String city;


    @Size(max = 250)
    private String country;



    @Size(max = 250)
    private String photoUrl;


    @OneToMany
    private List<Place> places;
}
