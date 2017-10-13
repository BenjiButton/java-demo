package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository personRepository;

    @Autowired
    PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    Collection<Person> readPeople(@PathVariable String name) throws UserNotFoundException {
        return this.personRepository.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public  void  savePerson(@RequestBody MultiValueMap<String, String> params){//(@RequestBody Person person) {
        System.out.println("params: " + params);

        //this.personRepository.save(person);
    }

}
