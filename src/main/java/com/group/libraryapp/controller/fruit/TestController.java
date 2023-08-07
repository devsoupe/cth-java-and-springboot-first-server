package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.controller.user.Fruit;
import com.group.libraryapp.repository.fruit.FruitMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final FruitMapper fruitMapper;

    public TestController(FruitMapper fruitMapper) {
        this.fruitMapper = fruitMapper;
    }

    @GetMapping("/test/mybatis")
    public void test() {
        List<Fruit> fruits = fruitMapper.findAll();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.getName());
            System.out.println(fruit.getPrice());
        }
    }

    @GetMapping("/test/mybatis2")
    public void test2() {
        List<Fruit> fruits = fruitMapper.findByName("바나나");
        for (Fruit fruit : fruits) {
            System.out.println(fruit.getName());
            System.out.println(fruit.getPrice());
        }
    }
}
