package com.gabortodor.petproject.entity;

import com.gabortodor.petproject.entity.constant.AnimalGender;
import com.gabortodor.petproject.entity.constant.AnimalType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Entity(name = "animal")
public class Animal extends BaseEntity{
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AnimalType type;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private AnimalGender gender;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private Instant birthDate;

    @Column(name = "brought_in_at")
    private Instant broughtInAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "breed_id", nullable = false)
    private Breed breed;

    @Column(name = "color")
    private String color;

    @Column(name = "fur_type")
    private String furType;

    @Column(name = "body_size")
    private String bodySize;

    @Column(name = "is_chipped")
    private Boolean chipped;

    @Column(name = "description")
    private String description;
}
