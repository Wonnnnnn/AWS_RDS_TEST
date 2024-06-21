package org.example.aws_sample.service;

import org.example.aws_sample.dto.User.UserCreateDto;
import org.example.aws_sample.dto.User.UserResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void addUser() {
        UserCreateDto userCreateDto = new UserCreateDto("aaa","apw","namea","a@email.com");
        UserResponseDto dto= userService.addUser(userCreateDto);
        assertThat(dto.getUsername()).isEqualTo(userCreateDto.getUsername());
    }
}