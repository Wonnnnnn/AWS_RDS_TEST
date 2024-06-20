package org.example.aws_sample.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private int userId;
    private String id;
    private String username;
    private String email;
}
