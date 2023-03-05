package com.example.cat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;

@Setter
@Getter
@Entity
@Table(name = "tags")
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false, unique = true, length = 25)
    private String tagName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TagClass tagClass;

    @RequiredArgsConstructor
    public enum TagClass {
        SPORT("Спорт"),
        POP_CULTURE("Поп-культура"),
        HOBBY("Хобби"),
        PASTIME("Времяпрепровождение");

        @Getter
        private final String value;

        public static TagClass from(String tagClassName) {
            return Arrays.stream(TagClass.values())
                    .filter(val -> val.getValue().equals(tagClassName))
                    .findFirst()
                    .orElseThrow(() -> new EnumConstantNotPresentException(TagClass.class, "No such tagClass:" + tagClassName));
        }
    }
}
