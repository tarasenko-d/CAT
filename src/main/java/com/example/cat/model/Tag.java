package com.example.cat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false, unique = true, length = 25)
    private String tagName;

    @Enumerated(EnumType.STRING)
    private TagClass tagClass;
    @ManyToMany
    @JoinTable(name = "event_tag",
            joinColumns = {@JoinColumn(name = "tag_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    private List<Event> events;

}
