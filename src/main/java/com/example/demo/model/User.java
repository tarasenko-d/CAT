package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 25)
    private String login;
    @Column(nullable = false, length = 35)
    private String password;
    private String userPicture;

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    private List<Event> createdEvents;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Tag> favouriteTags;

    @JoinTable(name = "user_event",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    @ManyToMany
    private List<Event> addedEvents;


    @Override
    public String toString() {
        return "User[" + id +
                "] login = " + login;
    }

    public String fullString() {
        return "User[" + id +
                "]\n  login = " + login +
                "\n  password = " + password +
                "\n  userPicture = " + userPicture +
                "\n  createdEvents = " + createdEvents +
               // "\n  favouriteTag=" + favouriteTag +
                "\n  addedEvents = " + addedEvents;
    }


}
