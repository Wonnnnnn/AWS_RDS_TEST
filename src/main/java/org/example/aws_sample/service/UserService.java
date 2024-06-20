package org.example.aws_sample.service;

import lombok.RequiredArgsConstructor;
import org.example.aws_sample.dto.User.UserCreateDto;
import org.example.aws_sample.dto.User.UserResponseDto;
import org.example.aws_sample.dto.User.UserUpdateDto;
import org.example.aws_sample.entity.User;
import org.example.aws_sample.exception.ValidationCheckException;
import org.example.aws_sample.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(int userId){
        return userRepository.findById(userId).get();
    }
    @Transactional
    public UserResponseDto addUser(UserCreateDto userCreateDto){
        validationCheck(userCreateDto);
        User user = new User(userCreateDto);
        userRepository.save(user);
        return new UserResponseDto(user.getUserId(),user.getId(),user.getName(),user.getEmail());
    }



    private void validationCheck(UserCreateDto userCreateDto){
        List<String> errorMessages = new ArrayList<>();
        if(userRepository.existsById(userCreateDto.getId())) {
            errorMessages.add("이미 사용된 user ID 입니다.");
        }
        if(userCreateDto.getUsername().length()>10){
            errorMessages.add("\n사용자 이름은 최대 10자리입니다.");
        }
        if(userCreateDto.getPassword().length()>10){
            errorMessages.add("\n사용자 비밀번호는 최대 10자리입니다.");
        }
        if (!errorMessages.isEmpty()) {
            throw new ValidationCheckException(errorMessages);
        }

    }

    @Transactional
    public void updateUser(UserUpdateDto userUpdateDto){
        User user=userRepository.findById(userUpdateDto.getUserId()).get();
        user.setEmail(userUpdateDto.getEmail());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }

}
