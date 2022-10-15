package uj.project.campusbuddyservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "profiles")
public class UploadProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String pictureULR;
    private String userEmail;
}
