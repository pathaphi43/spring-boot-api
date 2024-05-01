package com.me.cinemaapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "seats")
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long id;

    @NaturalId
    @Column(name = "seat_code", nullable = false, unique = true)
    private String code;

    @Column(name = "seat_row", unique = true, nullable = false)
    private String row;

    @Column(name = "seat_number", nullable = false)
    private int number;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Theaters.class)
    @JoinColumn(name = "theater_code", referencedColumnName = "theater_code", foreignKey = @ForeignKey(name = "theater_code_fk"))
    private Theaters theaters;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "booking_seat", joinColumns = @JoinColumn(name = "seat_code", referencedColumnName = "seat_code"), inverseJoinColumns = @JoinColumn(name = "booking_code", referencedColumnName = "booking_code"))
    private List<Bookings> bookings;
}
