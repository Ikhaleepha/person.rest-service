package io.mam.person.repository;

import io.mam.person.dto.Gender;
import io.mam.person.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class PersonRepository {

    private List<Person> persons = new ArrayList<>(
            Arrays.asList(
            new Person("01", "Muhammad", 30, Gender.MALE),
            new Person("02","Nasar", 25, Gender.MALE),
            new Person("03","Maryam", 26, Gender.FEMALE),
            new Person("04","Shafi'u", 41, Gender.MALE),
            new Person("05","Ilham", 2, Gender.FEMALE)
    ));

    public List<Person> findAll() {
        return persons;
    }

    public Optional<Person> findPersonById(String id) {
        return persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public String nextId() {
        return String.valueOf(findAll()
                                .size() + 1);
    }

    public boolean savePerson(Person person) {
        return persons.add(person);
    }
}
