package avi.test.personinfo.entity;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private long id;

    private String first_name;
    private String last_name;
    private int age;
    private String favourite_colour;
    @ElementCollection(targetClass=String.class)
    private List<String> hobby;
}
