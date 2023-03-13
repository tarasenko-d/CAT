package com.example.cat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String externalId;
    @Column(nullable = false, unique = true, length = 25)
    private String login;
    @Column(nullable = false, length = 35)
    private String password;
    private String userPicture;
    @ToString.Exclude
    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    private List<Event> createdEvents;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Tag> favouriteTags;
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "user_event",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    private List<Event> addedEvents;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", externalId=" + externalId +
                ", login='" + login + '\'' +
                '}';
    }
}
