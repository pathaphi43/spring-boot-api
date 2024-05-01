package com.me.cinemaapi.entities;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "show_times")
public class ShowTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "show_time_code", nullable = false,unique = true)
    private String code;

    @Timestamp
    @Column(name = "show_date")
    private Date date;

    @Column(name = "language")
    private String language;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Movies.class)
    @JoinColumn(name = "movie_code",referencedColumnName = "movie_code" ,foreignKey = @ForeignKey(name = "movie_code_fk"))
    private Movies movies;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity = Theaters.class)
    @JoinColumn(name = "theater_code",referencedColumnName = "theater_code",foreignKey = @ForeignKey(name = "theater_code_fk"))
    private Theaters theaters;

    @OneToMany(mappedBy = "code",cascade = CascadeType.ALL)
    private List<Bookings> bookings;
}
