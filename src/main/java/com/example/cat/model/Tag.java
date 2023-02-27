package com.example.cat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, length = 25)
    private String tagName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TagClass tagClass;

    public Tag(String tagName, TagClass tagClass) {
        this.tagName = tagName;
        this.tagClass = tagClass;
    }

    @RequiredArgsConstructor
    public enum TagClass {

        SPORT("Спорт"),
        POPCULTURE("Поп-культура"),
        HOBBY("Хобби"),
        PASTTIME("Времяпрепровождение");

        @Getter
        private final String value;

        public static TagClass from (String tagClassName){
            return Arrays.stream(TagClass.values())
                    .filter(val -> val.getValue().equals(tagClassName))
                    .findFirst()
                    .orElseThrow(()->new EnumConstantNotPresentException(TagClass.class,"No such tagClass:"+tagClassName));
        }

    }


}
