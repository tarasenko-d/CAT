package com.example.cat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false)
    private double latitude;
    @Column(nullable = false)
    private double longitude;
    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "user_event",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> members;

    @ManyToMany
    @JoinTable(name = "event_tag",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tags;


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title +
                ", creator=[" + creator.getId() +
                "] " + creator.getLogin() +
                '}';
    }

    public String fullString() {
        return "Event[" +id +
                "]\n title = " + title +
                "\n latitude = " + latitude +
                "\n longitude = " + longitude +
                "\n creator = User[" + creator.getId() +
                "] " + creator.getLogin() +
                "\n members:\n " + members;
    }
}
