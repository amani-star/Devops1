package tn.esprit.springproject.controlleurs;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.springproject.entities.*;
import tn.esprit.springproject.services.IUniversiteService;

import org.springframework.http.HttpHeaders;
import tn.esprit.springproject.services.UniversiteServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class UniversiteController {
    UniversiteServiceImpl universiteService;
    private static final String BASE_URL = "your_base_url_here";

/*@RequestBody Universite universite*/
    @PostMapping("/addUniversite/{idVille}")
    public Universite addUni (@PathVariable("idVille") Long villeId, @ModelAttribute Universite universite, @RequestParam("file") MultipartFile file) throws Exception {
        return universiteService.addUniversiteVille(universite,villeId,file);
    }

    @GetMapping("/universite/{id}")
    Universite retrieveUniversite(@PathVariable Long id) {
        return universiteService.getUniversite(id);
    }

    @GetMapping("/universite")
    List<Universite> retrieveUniversites() {
        return universiteService.getAllUniversites();
    }
@GetMapping("/alluniversite")
ResponseEntity<List<Universite>>getAllUniversites(Pageable pageable) {
      Page<Universite> page=universiteService.getAllUniversites(pageable);
  HttpHeaders headers= PaginationUtil.generatePaginationHttpHeaders(page,BASE_URL);
   /* return universiteService.getAllUniversites(pageable);*/
return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    @DeleteMapping("/deleteuniversite/{id}")
    void deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
    }
    @DeleteMapping("/deleteuniversite/all/{ids}")
    void deleteUniversiteParLot(@PathVariable  List<Long>ids) throws Exception {
        universiteService.deleteUniversiteParLot(ids);
    }


    @PutMapping("/updateuniversite")
    Universite updateUniversite(@ModelAttribute Universite universite, @RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        return universiteService.updateUniversite(universite, file);
    }

    @GetMapping("/findUniversiteByName/{nomUniversite}")
    Universite findUniversiteByName(@PathVariable String nomUniversite) {
        return universiteService.findUniversiteByName(nomUniversite);
    }/////////////////////

    @GetMapping("/nbrDepartementsByUniversite/{idUniversite}")
    Long nbrDepartementsByUniversite(@PathVariable Long idUniversite) {
        return universiteService.nbrDepartementsByUniversite(idUniversite);
    }/////////////////////

    @GetMapping("/getUniversitiesSorted")
    TreeSet<Universite> getUniversitiesSorted() {
        return universiteService.getUniversitiesSorted();
    }

    ///
    @PutMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable Long idUniversite, @PathVariable Long idDepartement) {
        universiteService.assignUniversiteToDepartement(idUniversite, idDepartement);
    }

@GetMapping("/universitebyville/{idVille}")
    public List<Universite> getUniversiteByVille(@PathVariable long idVille){
        return universiteService.getUniversiteByVille(idVille);
}
@GetMapping("/getDepartementsByUniversite/{idUniversite}")
public List<Departement> getDepartementsByUniversite(@PathVariable Long idUniversite) {
    return universiteService.getDepartementsByUniversite(idUniversite);
}
@GetMapping("/getDataByFiltre/{idVille}/{idUniversite}/{idDepartement}")
public List<Filtre> getDataByFiltre(@PathVariable long idVille, @PathVariable long idUniversite,@PathVariable long idDepartement) {
return  universiteService.getDataByFiltre(idVille,idUniversite,idDepartement);
    }




}




