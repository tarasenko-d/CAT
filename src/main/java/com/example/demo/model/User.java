package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 25)
    private String login;
    @Column(nullable = false, length = 35)
    private String password;

    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER)
    private Set<Event> createdEvents;

    @JoinTable(name = "user_event",
               joinColumns = {@JoinColumn(name = "user_id")},
               inverseJoinColumns = {@JoinColumn(name = "event_id")})
    @ManyToMany
    private Set<Event> addedEvents = new HashSet<>(0);


    public void addCreatedEvent(Event event) {
        createdEvents.add(event);
        event.setCreator(this);
    }

    public void removeCreatedEvent(Event event) {
        createdEvents.remove(event);
        event.setCreator(null);
    }

    public void followEvent(Event event){
        addedEvents.add(event);
        event.addMember(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdEvents=" + createdEvents +
                ", addedEvents=" + addedEvents +
                '}';
    }
}
