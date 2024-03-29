package com.example.cat.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false, length = 50)
    private String title;
    private double latitude;
    private double longitude;
    private LocalDateTime eventDate;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "user_event",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> members;
    @ManyToMany
    @JoinTable(name = "event_tag",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tags;
}
