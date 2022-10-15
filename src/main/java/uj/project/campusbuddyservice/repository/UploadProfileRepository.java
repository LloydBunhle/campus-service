package uj.project.campusbuddyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uj.project.campusbuddyservice.entity.UploadProfile;

import java.util.List;

public interface UploadProfileRepository extends JpaRepository<UploadProfile,Long> {

    List<UploadProfile> findAllByUserEmail(String userEmail);
}
