package uj.project.campusbuddyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uj.project.campusbuddyservice.entity.Markets;

import java.util.List;

public interface MarketRepository extends JpaRepository<Markets,Long> {
    List<Markets> findAllById(int id);

    List<Markets> findAllByEmail(String email);

    List<Markets> deleteAllById(long id);
}
