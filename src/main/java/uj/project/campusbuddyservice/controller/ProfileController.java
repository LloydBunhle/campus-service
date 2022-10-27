package uj.project.campusbuddyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uj.project.campusbuddyservice.services.Profile;

import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ProfileController {

    @Autowired
    private Profile profileService;

    @GetMapping("/details/{email}")
    public ResponseEntity<?> getProfile(@PathVariable("email") String email){
        try{
            return  profileService.getUserProfile(email);
        }catch (Exception e){
            return  new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }
}
