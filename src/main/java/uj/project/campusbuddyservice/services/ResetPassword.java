package uj.project.campusbuddyservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uj.project.campusbuddyservice.dto.ResetPasswordDto;
import uj.project.campusbuddyservice.entity.Role;
import uj.project.campusbuddyservice.entity.User;
import uj.project.campusbuddyservice.repository.RoleRepository;
import uj.project.campusbuddyservice.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ResetPassword {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;
    public ResponseEntity<?> resetPassword(ResetPasswordDto resetPasswordDto) {
//        User users = (User) userRepository.findEmail(resetPasswordDto.getEmail());
        Optional<User> userfound = userRepository.findByUsernameOrEmail(resetPasswordDto.getEmail() , resetPasswordDto.getEmail());
        System.out.println(userfound);
        if(!userfound.isPresent()){
            return new ResponseEntity<>("Email does not exists", HttpStatus.BAD_REQUEST);
        }
        User users = userfound.get();
        users.setName(users.getName());
        users.setUsername(users.getUsername());
        users.setSurname(users.getSurname());
        users.setStudentNumber(users.getStudentNumber());
        users.setCourse(users.getCourse());
        users.setEmail(users.getEmail());
//        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
//        users.setRoles(Collections.singleton(roles));
        users.setPassword(passwordEncoder.encode(resetPasswordDto.getNewPassword()));
        userRepository.save(users);
        return new ResponseEntity<>("Password has been successfully rested", HttpStatus.OK);
    }
}
