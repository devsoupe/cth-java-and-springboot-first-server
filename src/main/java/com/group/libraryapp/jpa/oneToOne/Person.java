package com.group.libraryapp.jpa.oneToOne;

import jakarta.persistence.*;


/***
 * create table person
 * (
 *      id bigint auto_increment,
 *      name varchar(255),
 *      address_id bigint, // Person이 Address를 가지고 있게 함
 *      primary key (id)
 * );
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String name;

    @OneToOne
    private Address address;

    protected Person() {}

    public void setAddress(Address address) {
        this.address = address;
        this.address.setPerson(this); // 연관관계 테이블 연결 이후 객체 연결도 해주기 위해
    }
}
