package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    /**
     * http://localhost:8080/addv2?number1=10&number2=20
     */

    @GetMapping("/add") // GET /add?number1=10&number2=20
    public int addTwoNumbersV1(
            @RequestParam int number1,
            @RequestParam int number2
    ) {
        return number1 + number2;
    }

    @GetMapping("/addv2")
    public int addTwoNumbersV2(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

}
