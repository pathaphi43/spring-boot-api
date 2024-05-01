package com.me.cinemaapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "theaters")
public class Theaters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_id")
    private Long id;

    @NaturalId
    @Column(name = "theater_code", nullable = false, unique = true)
    private String code;

    @Column(name = "theater_name")
    private String name;

    @Column(name = "theater_address")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "code")
    private List<Seats> seats;

}
