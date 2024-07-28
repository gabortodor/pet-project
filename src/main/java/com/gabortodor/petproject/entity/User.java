package com.gabortodor.petproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Entity(name = "user") //TODO
public class User extends BaseEntity {
    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "is_verified")
    private Boolean verified;

    @Column(name = "is_locked_out")
    private Boolean lockedOut;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_favourited_animals",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id")
    )
    private List<Animal> favouritedAnimals;

    @OneToMany
    private List<Animal> searchedAnimals;

}
