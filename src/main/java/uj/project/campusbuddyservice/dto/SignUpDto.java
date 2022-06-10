package uj.project.campusbuddyservice.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String name;
    private String username;
    private String course;
    private String email;
    private String password;
}
