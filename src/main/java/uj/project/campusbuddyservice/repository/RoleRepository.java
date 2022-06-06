package uj.project.campusbuddyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uj.project.campusbuddyservice.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
