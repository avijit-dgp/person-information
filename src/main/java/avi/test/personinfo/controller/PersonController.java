package avi.test.personinfo.controller;

import avi.test.personinfo.entity.Person;
import avi.test.personinfo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable long personId) {
        return new ResponseEntity<>(personService.getPersonById(personId), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewPerson(@RequestBody @Valid Person person) {
        personService.createPerson(person);
    }

    @PutMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable long personId, @RequestBody @Valid Person person) {
        personService.updatePerson(personId, person);
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable long personId) {
        personService.deletePersonById(personId);
    }
}
