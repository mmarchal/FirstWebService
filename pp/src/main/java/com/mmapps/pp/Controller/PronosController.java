package com.mmapps.pp.Controller;

import com.mmapps.pp.Dto.PronosDto;

import com.mmapps.pp.Entity.Pronos;
import com.mmapps.pp.Repository.PronosRepository;
import com.mmapps.pp.Services.PronosService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Slf4j
@Controller
@RestController
@RequestMapping(path = "/pronos")
public class PronosController {

    @Autowired
    PronosService pronosService;

    @Autowired
    PronosRepository pronosRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/listes")
    public List getPronos() {
        log.info("Listes de pronostics recuperees !");
        return pronosRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/nombre")
    public long getNumbersOfPronos() {
        log.info("Nombres de pronostics recuperees !");
        return pronosRepository.count();
    }

    @PostMapping(path="/add")
    public boolean addProno(@RequestBody PronosDto pronos) {
        return pronosService.addToDatabase(pronos);
    }

    @PostMapping("/update")
    public boolean updateProno(@RequestBody PronosDto pronosDto ) {
        return pronosService.UpdateData(pronosDto);
    }

    @GetMapping(path = "/{dateDuJour}/get")
    public Collection<Pronos> pronoDuJour(@PathVariable(name = "dateDuJour") Date date) {
        log.info("Pronostic du " + date + " recupere !");
        return pronosService.getTodayProno(date);
    }

    @GetMapping(path = "get/{dateDuJour}/{type}")
    public Collection<Pronos> pronoByDateAndType(@PathVariable(name = "dateDuJour") Date dateDuJour, @PathVariable(name = "type") String type) {
        log.info("Pronostic " + type + " le " + dateDuJour);
        return pronosService.getTypeForToday(dateDuJour, type);
    }

    @GetMapping(path = "/{dateDebut}/{dateFin}/get")
    public Collection<Pronos> datePronos(@PathVariable(name = "dateDebut") Date dateDebut,@PathVariable(name = "dateFin") Date dateFin) {
        log.info("Pronos recuperes !");
        return pronosService.getPronoByDate(dateDebut,dateFin);
    }

    @DeleteMapping("/{id}/delete")
    public void suppPronos(@PathVariable long id) {
        pronosRepository.deleteById(id);
        log.info("Pronostic n°" + id + " supprime de la base de donnees !");
    }

    /*@GetMapping("/allResults")
    public Collection<Pronos> allResults() {
        log.info("Resultats recuperes !");
        return pronosService.getAllResults();
    }*/


}
