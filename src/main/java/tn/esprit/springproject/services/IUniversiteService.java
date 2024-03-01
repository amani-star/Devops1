package tn.esprit.springproject.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Filtre;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.entities.Ville;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

public interface IUniversiteService {
    Universite addUniversiteVille(Universite universite,Long idVille,MultipartFile file) throws Exception;
    List<Universite> getAllUniversites();
      Page<Universite> getAllUniversites(Pageable pageable);
    Universite getUniversite(Long idUniversite);
    List<Universite>  getUniversiteByVille(long idVille);
   /* List<Departement> getDepartementByUniversite(long idUniversite);*/
    void deleteUniversite(Long idUniversite);
    public Universite updateUniversite(Universite universite, MultipartFile file) throws IOException;
    Universite findUniversiteByName(String nomUniversite);
    List<Departement> getDepartementsByUniversite(Long idUniversite);
    Long nbrDepartementsByUniversite(Long idUniversite);
    TreeSet<Universite> getUniversitiesSorted();
    void assignUniversiteToDepartement(Long idUniversite, Long idDepartement);

    void deleteUniversiteParLot(List<Long>ids) throws Exception;
    List<Filtre> getDataByFiltre(long idVille, long idUniversite, long idDepartement);


}
