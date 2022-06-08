package uj.project.campusbuddyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uj.project.campusbuddyservice.dto.ResetPasswordDto;
import uj.project.campusbuddyservice.services.ResetPassword;

@RestController
@RequestMapping("/api/auth")
public class ResetPasswordController {

    @Autowired
    private ResetPassword resetPassword;

    @PutMapping("/reset")
    public ResponseEntity<?> resetUserPasssword(@RequestBody ResetPasswordDto resetPasswordDto){
        return resetPassword.resetPassword(resetPasswordDto);
//        try{
//
//        }catch (Exception e){
//            return  new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
//
//        }
    }
}
