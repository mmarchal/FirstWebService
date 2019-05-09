package com.mmapps.pp.Services;

import com.mmapps.pp.Dto.PronosDto;
import com.mmapps.pp.Entity.Pronos;
import com.mmapps.pp.Repository.PronosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collection;

@Service
@Slf4j
public class PronosService
{
    @Autowired
    PronosRepository pronosRepository;

    public boolean addToDatabase(PronosDto pronos)
    {
        if(pronos.getCote()!=null&&pronos.getDateMatch()!=null)
        {
            Pronos pronoToSave = new Pronos();
            pronoToSave.setCote(pronos.getCote());
            pronoToSave.setDateMatch(pronos.getDateMatch());
            pronoToSave.setExplication(pronos.getExplication());
            pronoToSave.setId(pronos.getId());
            pronoToSave.setPrediction(pronos.getPrediction());
            pronoToSave.setSport(pronos.getSport());
            pronoToSave.setMatchs(pronos.getMatch());
            pronoToSave.setType(pronos.getType());
            pronosRepository.save(pronoToSave);
            log.info("Prono " + pronoToSave.getMatchs() +" enregistre ! ");
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean UpdateData(PronosDto pronosDto) {

        Pronos pronos = pronosRepository.getOne(pronosDto.getId());

        if (pronos.getMatchs()!=null && pronos.getCote()!=null)
        {
            pronos.setSport(pronosDto.getSport());
            pronos.setCote(pronosDto.getCote());
            pronos.setExplication(pronosDto.getExplication());
            pronos.setPrediction(pronosDto.getPrediction());
            pronos.setDateMatch(pronosDto.getDateMatch());
            pronos.setMatchs(pronosDto.getMatch());
            pronos.setType(pronosDto.getType());
            log.info("Pronostic mis a jour !");
            pronosRepository.save(pronos);
            return true;

        } else {

            log.info("Pronostic non mis a jour !");
            return false;
        }

    }

    public Collection<Pronos> getPronoByDate(Date dateDebut,Date dateFin) {
       return pronosRepository.getPronosByDate(dateDebut,dateFin);
    }

    public Collection<Pronos> getTodayProno(Date date) {
        return pronosRepository.getTodayProno(date);
    }

    public Collection<Pronos> getTypeForToday(Date date, String typeProno) {
        return pronosRepository.pronoForToday(date, typeProno);
    }

    public Collection<Pronos> getAllResults() {
        return pronosRepository.getAllResults();
    }
}
