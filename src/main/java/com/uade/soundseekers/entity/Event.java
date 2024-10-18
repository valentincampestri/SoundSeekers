package com.uade.soundseekers.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double latitude;

    private Double longitude;

    private LocalDateTime dateTime;

    private Double price;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "event_users",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> attendees = new ArrayList<>();

    @ElementCollection(targetClass = musicGenre.class)
    @Enumerated(EnumType.STRING)
    private List<musicGenre> genres = new ArrayList<>();

    @ManyToOne
    private User organizer;
}