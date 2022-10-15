package uj.project.campusbuddyservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import uj.project.campusbuddyservice.dto.UploadDto;
import uj.project.campusbuddyservice.entity.UploadProfile;
import uj.project.campusbuddyservice.repository.UploadProfileRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UploadProfileService {

    @Autowired
    private UploadProfileRepository uploadProfileRepository;

    public ResponseEntity<?> createProfile(UploadDto uploadDto){
        try{
            UploadProfile newPicture = new UploadProfile();
             newPicture.setPictureULR(uploadDto.getPictureULR());
             newPicture.setUserEmail(uploadDto.getUserEmail());
             uploadProfileRepository.save(newPicture);
             return ResponseEntity.status(HttpStatus.OK).body(Optional.of(newPicture));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Optional.of("No Content Found"));
        }
    }

    public ResponseEntity<?> getUserProfilePic(String email){
        try{
            List<UploadProfile> allProfile = uploadProfileRepository.findAllByUserEmail(email);
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(allProfile));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Optional.of("No content"));
        }
    }
}
