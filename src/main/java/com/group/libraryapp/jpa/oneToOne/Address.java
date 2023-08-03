package com.group.libraryapp.jpa.oneToOne;

import jakarta.persistence.*;

/***
 * create table address
 * (
 *      id bigint auto_increment,
 *      city varchar(255),
 *      street varchar(255),
 *      primary key (id)
 * );
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String city;

    private String street;

    @OneToOne(mappedBy = "address") // oneToOne 에서 연관관계 주인은 fk가 있는쪽, 주인이 아닌곳은 mappedBy를 세팅해주어야 함
    private Person person;

    protected Address() {}

    public void setPerson(Person person) {
        this.person = person;
    }
}
