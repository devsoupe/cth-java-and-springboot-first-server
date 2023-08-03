package com.group.libraryapp.jpa.oneToOne;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final AddressRepository addressRepository;

    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void savePerson() {
        Person person = personRepository.save(new Person());
        Address address = addressRepository.save(new Address());

        person.setAddress(address); // 연관관계 주인 인곳에서 주인이 아닌걸 set, 연결 잘됨
//        address.setPerson(person); // 연관관계 주인이 아닌곳에서 주인을 set, 연결 안됨

        // @Transactional 영속성 속성의 변경감지로 인해 생략 가능
        // personRepository.save(person);
    }
}
