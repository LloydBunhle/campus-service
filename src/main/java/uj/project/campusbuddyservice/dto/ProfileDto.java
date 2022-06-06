package uj.project.campusbuddyservice.dto;
import lombok.Data;

@Data
public class ProfileDto {
    private long id;
    private String name;
    private String surname;
    private String username;
    private String studentNumber;
    private String course;
    private String email;
}
