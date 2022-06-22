package uj.project.campusbuddyservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "products")
public class Markets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private String condition;
    private String price;
    private String itemUrl;
    private String email;
}
