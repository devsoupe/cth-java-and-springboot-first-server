package com.group.libraryapp.jpa.oneToOne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/test/person")
    public void testPerson() {
        personService.savePerson();
    }
}
