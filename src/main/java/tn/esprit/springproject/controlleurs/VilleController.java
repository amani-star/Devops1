package tn.esprit.springproject.controlleurs;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Ville;
import tn.esprit.springproject.services.IVilleService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class VilleController {
    IVilleService villeService;
    @PostMapping("/addville")
    Ville addVille(@RequestBody Ville ville){
        return  villeService.addVille(ville);
    }

    @GetMapping("/ville/{id}")
    Ville retrieveVille(@PathVariable Long id)
    {return  villeService.getVile(id);}
    @GetMapping("/ville")
    List<Ville> retrieveVilles(){
        return  villeService.getAllVilless();
    }
    @DeleteMapping ("/deleteville/{id}")
    void deleteVille(@PathVariable Long id){
        villeService.deleteVille(id);
    }
    @PutMapping("/updateville")
    Ville updateVille(@RequestBody Ville ville) throws Exception {
        return villeService.updateVille(ville);
    }





}
