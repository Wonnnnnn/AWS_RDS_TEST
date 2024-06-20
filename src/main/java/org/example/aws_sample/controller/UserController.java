package org.example.aws_sample.controller;

import lombok.RequiredArgsConstructor;
import org.example.aws_sample.dto.User.UserResponseDto;
import org.example.aws_sample.entity.User;
import org.example.aws_sample.dto.User.UserCreateDto;
import org.example.aws_sample.dto.User.UserUpdateDto;
import org.example.aws_sample.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAllUser() {
        return userService.getAllUser()
                .stream()
                .map( u -> new UserResponseDto(
                        u.getUserId(),
                        u.getId(),
                        u.getName(),
                        u.getEmail()
                        ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUserById(@PathVariable("userId") int userId) {

        User user = userService.getUserById(userId);
        return new UserResponseDto(user.getUserId(), user.getId(), user.getName(), user.getEmail());
    }

    @PostMapping
    public UserResponseDto addUser(@RequestBody UserCreateDto userCreateDto){

        return userService.addUser(userCreateDto);
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
