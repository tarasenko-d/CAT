package com.example.cat.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false, unique = true, length = 25)
    private String login;
    @Column(nullable = false, length = 35)
    private String password;
    private String userPicture;

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Event> createdEvents;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Tag> favouriteTags;

    @JoinTable(name = "user_event",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    @ManyToMany
    private List<Event> addedEvents;
}
