package avi.test.personinfo.service;

import avi.test.personinfo.entity.Person;

public interface PersonService {
    Person getPersonById(long personId);

    void createPerson(Person beer);

    void updatePerson(long personId, Person beer);

    void deletePersonById(long personId);
}
