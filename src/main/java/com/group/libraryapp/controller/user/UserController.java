package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.fruit.FruitService;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

//    @Autowired
//    private UserService userService;

    private final UserServiceV2 userService;
    private final FruitService fruitService;

    public UserController(UserServiceV2 userServiceV2, @Qualifier("main") FruitService fruitService) {
        this.userService = userServiceV2;
        this.fruitService = fruitService;
    }

//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

    @GetMapping("/fruit")
    public Fruit fruit() {
        return new Fruit("바나나", 2000);
    }

    @GetMapping("/user/error-test")
    public void errorTest() {
        throw new IllegalArgumentException();
    }
}
