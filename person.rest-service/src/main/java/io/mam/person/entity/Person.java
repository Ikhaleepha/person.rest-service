package io.mam.person.entity;

import io.mam.person.dto.Gender;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private String id;
    private String name;
    private int age;
    private Gender gender;
}
