package tn.esprit.springproject.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Filtre;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.entities.Ville;

import java.awt.print.Pageable;
import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findUniversiteByNomUniversite(String nomUniversite);

    @Query("SELECT u FROM Universite u WHERE u.idUniversite IN :ids")
    List<Universite> findByIds(@Param("ids") List<Long> ids);
 List<Universite> findByVille(Ville ville);
    @Query("SELECT d FROM Departement d  JOIN d.universite u WHERE  u.idUniversite = :univId")
    List<Departement> findDepartementByUniversite(@Param("univId") Long idUniversite);

    @Query("SELECT d FROM Departement d  JOIN d.universite u WHERE    u.ville.idVille = :idvil")
    List<Departement> findDepartementByUniversiteByVille(@Param("idvil") Long idVille);

 //  Page <Universite> findAll(Pageable pageable);


}
