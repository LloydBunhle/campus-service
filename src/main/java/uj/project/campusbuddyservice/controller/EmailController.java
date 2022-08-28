package uj.project.campusbuddyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uj.project.campusbuddyservice.dto.SendMailDto;
import uj.project.campusbuddyservice.entity.EmailDetails;
import uj.project.campusbuddyservice.services.EmailService;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody EmailDetails details){
        return emailService.sendEmail(details);
    }

}
