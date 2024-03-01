package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Images;

public interface ImagesRepository extends JpaRepository<Images, Integer> {
}
