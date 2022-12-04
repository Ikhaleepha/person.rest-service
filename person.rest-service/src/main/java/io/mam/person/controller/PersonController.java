package io.mam.person.controller;

import io.mam.person.dto.PersonDto;
import io.mam.person.dto.Response;
import io.mam.person.entity.Person;
import io.mam.person.service.PersonService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonService personSvc;

    public String home() {
        return "<h1> Hello World!";
    }

    @GetMapping("/person")
    public List<PersonDto> getAllPersons() {
        return personSvc.getAllPersons();
    }

    @GetMapping("/person/{id}")
    @ApiOperation(
            value = "Finds person by id",
            notes = "Provides an id to look up specific person",
            response = PersonDto.class
    )
    public Response getPerson(@PathVariable String id) {
        return personSvc.getPerson(id);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        return personSvc.addPerson(person);
    }
}
