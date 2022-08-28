package uj.project.campusbuddyservice.dto;

import lombok.Data;

@Data
public class SendMailDto {
    private String recipient;
    private String msgBody;
    private String subject;
}
