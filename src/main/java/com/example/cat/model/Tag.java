package com.example.cat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;

@Data
@Entity
@Table(name = "tags")
@AllArgsConstructor
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
