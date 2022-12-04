package io.mam.person.dto;

import io.mam.person.dto.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {

    private String name;
    private int age;
    private Gender gender;
}
