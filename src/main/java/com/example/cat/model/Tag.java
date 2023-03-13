package com.example.cat.model;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;

@Data
@Entity
@Table(name = "tags")
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String externalId;
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
