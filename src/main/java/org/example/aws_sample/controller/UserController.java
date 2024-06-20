package org.example.aws_sample.controller;

import lombok.RequiredArgsConstructor;
import org.example.aws_sample.entity.User;
import org.example.aws_sample.dto.User.UserCreateDto;
import org.example.aws_sample.dto.User.UserUpdateDto;
import org.example.aws_sample.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public int addUser(@RequestBody UserCreateDto userCreateDto){
        int id = userService.addUser(userCreateDto);
        return id;
    }

    @PutMapping
    public void updateUser(@RequestBody UserUpdateDto userUpdateDto) {
        userService.updateUser(userUpdateDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
    }

}
