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
@Table(name = "tags")
public class Tag {
    @Id
    private Long id;
    @Column(nullable = false)
    private String tagName;

    @Enumerated(EnumType.STRING)
    private TagClass tagClass;
    @ManyToMany
    @JoinTable(name = "event_tag",
            joinColumns = {@JoinColumn(name = "tag_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    private List<Event> events;


}
