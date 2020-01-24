package avi.test.personinfo.service;

import avi.test.personinfo.entity.Person;
import avi.test.personinfo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    
    @Override
    public Person getPersonById(long personId) {
        return personRepository.findById(personId)
                .orElseThrow(RuntimeException :: new);
    }

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(long personId, Person person) {
        Optional<Person> fetchedPerson = personRepository.findById(personId);
        if(fetchedPerson.isPresent()) {
            Person personInDb = fetchedPerson.get();
            personInDb.setFirst_name(person.getFirst_name());
            personInDb.setLast_name(person.getLast_name());
            personInDb.setAge(person.getAge());
            personInDb.setFavourite_colour(person.getFavourite_colour());
            personInDb.setHobby(person.getHobby());
            personRepository.save(personInDb);
        }
    }

    @Override
    public void deletePersonById(long personId) {
        personRepository.deleteById(personId);
    }
}
