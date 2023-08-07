package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitJdbcRepository;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.repository.fruit.FruitMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class TestController {

    private final FruitMapper fruitMapper;
    private final FruitRepository fruitRepository;
    private final FruitJdbcRepository fruitJdbcRepository;

    public TestController(FruitMapper fruitMapper, FruitRepository fruitRepository, FruitJdbcRepository fruitJdbcRepository) {
        this.fruitMapper = fruitMapper;
        this.fruitRepository = fruitRepository;
        this.fruitJdbcRepository = fruitJdbcRepository;
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

    @GetMapping("/test/save1")
    public void saveTest1() {
        List<Fruit> fruits = prepareFruits();
        long startMills = System.currentTimeMillis();
        fruitRepository.saveAll(fruits);
        System.out.printf("소요 시간, %sms\n", System.currentTimeMillis() - startMills);
    }

    @GetMapping("/test/save2")
    public void saveTest2() {
        List<Fruit> fruits = prepareFruits();
        long startMills = System.currentTimeMillis();
        fruitJdbcRepository.saveAllBatch(fruits);
        System.out.printf("소요 시간, %sms\n", System.currentTimeMillis() - startMills);
    }

    private List<Fruit> prepareFruits() {
        List<Fruit> fruits = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100_000; i++) {
            fruits.add(new Fruit("사과", random.nextInt(20_000)));
        }
        return fruits;
    }
}
