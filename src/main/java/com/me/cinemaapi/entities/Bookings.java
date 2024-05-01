package com.me.cinemaapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "bookings")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "booking_code")
    private String code;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ShowTimes.class)
    @JoinColumn(name = "show_time_code", referencedColumnName = "show_time_code", foreignKey = @ForeignKey(name = "show_time_code_fk"))
    private ShowTimes showTimes;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "user_code", referencedColumnName = "user_code", foreignKey = @ForeignKey(name = "user_code_fk"))
    private Users users;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "booking_seat", joinColumns = @JoinColumn(name = "booking_code", referencedColumnName = "booking_code"), inverseJoinColumns = @JoinColumn(name = "seat_code", referencedColumnName = "seat_code"))
    private List<Seats> seats;
}
