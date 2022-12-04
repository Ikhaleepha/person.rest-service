package io.mam.person.error;

import io.mam.person.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFound extends RuntimeException {

    public PersonNotFound() {
        super("Person With the Specified ID Not found");
    }
}
