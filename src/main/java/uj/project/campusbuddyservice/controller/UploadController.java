package uj.project.campusbuddyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uj.project.campusbuddyservice.dto.UploadDto;
import uj.project.campusbuddyservice.services.UploadProfileService;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UploadController {

    @Autowired
    private UploadProfileService uploadProfileService;

    @GetMapping("/profile/{email}")
    public ResponseEntity<?> getProfile(@PathVariable("email") String userMail){
        return uploadProfileService.getUserProfilePic(userMail);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createNewProfile(@RequestBody UploadDto uploadDto){
        return uploadProfileService.createProfile(uploadDto);
    }
}
