package io.mam.person.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {

    private String responseCode;
    private String responseDesc;
    private PersonDto personDto = new PersonDto();
}
