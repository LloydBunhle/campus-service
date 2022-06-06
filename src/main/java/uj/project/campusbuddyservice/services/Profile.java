package uj.project.campusbuddyservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import uj.project.campusbuddyservice.dto.ProfileDto;
import uj.project.campusbuddyservice.entity.User;
import uj.project.campusbuddyservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class Profile {

    @Autowired
    private UserRepository userProfile;

    @Autowired
    private ModelMapper modelMapper;
    public ResponseEntity<?> getUserProfile(String email){
        try{
            List<ProfileDto> details = userProfile.findByEmail(email)
                    .stream()
                    .map(users -> modelMapper.map(users, ProfileDto.class))
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(details));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Optional.of("No Content Found"));
        }
    }

}
