package io.mam.person.service;

import io.mam.person.dto.PersonDto;
import io.mam.person.dto.Response;
import io.mam.person.entity.Person;
import io.mam.person.error.PersonNotFound;
import io.mam.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepo;

    private final Logger logger;

    public List<PersonDto> getAllPersons() {
        logger.info("Getting All Persons");

        List<Person> persons = personRepo.findAll();
        return persons.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Response getPerson(String id) {
        logger.info("Getting person with Id {}", id);
       //throw new PersonNotFound();


        return personRepo.findPersonById(id)
                .map(this::mapToSuccessfulResponse)
                .orElseGet(this::unsuccessfulResponse);

    }
    public Person addPerson(Person person) {
        person.setId(personRepo.nextId());
        logger.info("Saving person {}", person);
        personRepo.savePerson(person);
        return person;
    }

    private PersonDto toDto(Person person) {
        return PersonDto.builder()
                .name(person.getName())
                .age(person.getAge())
                .gender(person.getGender())
                .build();
    }

    private Response mapToSuccessfulResponse(Person person) {
        return Response.builder()
                .responseCode("400")
                .responseDesc("Person With the Specified ID Not found")
                .personDto(toDto(person))
                .build();
    }

    private Response unsuccessfulResponse() {
        return Response.builder()
                .responseCode("400")
                .responseDesc("Person With the Specified ID Not found")
                .personDto(null)
                .build();
    }

    private PersonDto personToPersonDTO(Person person) {
        return PersonDto.builder()
                .name(person.getName())
                .age(person.getAge())
                .gender(person.getGender())
                .build();
    }

}
