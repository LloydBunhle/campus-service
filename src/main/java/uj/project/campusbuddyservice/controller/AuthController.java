package uj.project.campusbuddyservice.controller;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uj.project.campusbuddyservice.dto.LoginDto;
import uj.project.campusbuddyservice.dto.SignUpDto;
import uj.project.campusbuddyservice.entity.Role;
import uj.project.campusbuddyservice.entity.User;
import uj.project.campusbuddyservice.repository.RoleRepository;
import uj.project.campusbuddyservice.repository.UserRepository;
import uj.project.campusbuddyservice.services.Profile;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Profile profileService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto){
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsernameOrEmail(), loginDto.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            profileService.getUserProfile(loginDto.getUsernameOrEmail());

            return new ResponseEntity<>( profileService.getUserProfile(loginDto.getUsernameOrEmail()), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Invalid details.", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

//        try{
            // add check for username exists in a DB
            if(userRepository.existsByUsername(signUpDto.getUsername())){
                return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
            }

            // add check for email exists in DB
            if(userRepository.existsByEmail(signUpDto.getEmail())){
                return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
            }

            // create user object
            User user = new User();
            user.setName(signUpDto.getName());
            user.setUsername(signUpDto.getUsername());
            user.setCourse(signUpDto.getCourse());
            user.setEmail(signUpDto.getEmail());
            user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

//            Role roles = roleRepository.findByName("ROLE_ADMIN").get();
//            user.setRoles(Collections.singleton(roles));

            userRepository.save(user);

            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
//        } catch (Exception e){
//            return  new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
//        }


    }
}
