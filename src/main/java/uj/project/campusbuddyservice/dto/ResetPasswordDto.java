package uj.project.campusbuddyservice.dto;

import lombok.Data;

@Data
public class ResetPasswordDto {
    private String email;
    private String username;
    private String newPassword;
}
