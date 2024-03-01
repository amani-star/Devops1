package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Filtre;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Ville;

import java.util.List;

public interface IVilleService {

    Ville addVille(Ville ville);
    List<Ville> getAllVilless();
    Ville getVile(Long idVille);
    void deleteVille(Long idVille);
    Ville updateVille(Ville ville) throws Exception;

}
