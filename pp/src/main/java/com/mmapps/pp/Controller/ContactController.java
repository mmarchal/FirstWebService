package com.mmapps.pp.Controller;

import com.mmapps.pp.Dto.ContactDto;
import com.mmapps.pp.Repository.ContactRepository;
import com.mmapps.pp.Services.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @Autowired
    ContactRepository contactRepository;

    @GetMapping(path = "/getAll")
    public List getAllMessages() {
        log.info("Liste des messages recuperes !");
        return contactRepository.findAll();
    }

    @PostMapping(path="/add")
    public String addMessage(@RequestBody ContactDto contactDto) {
        boolean response = contactService.sendMessage(contactDto);
        if (response) {
            return "Message envoye ! Merci !";
        } else {
            return "Message non envoye ! Veuillez verifier que tous les parametres soient bien rempli.";
        }
    }

    @GetMapping("/nombre")
    public long getNumbersOfMessages() {
        log.info("Nombres de pronostics recuperees !");
        return contactRepository.count();
    }

    @DeleteMapping("/{id}/delete")
    public void suppMessage(@PathVariable long id) {
        contactRepository.deleteById(id);
        log.info("Message n°" + id + " supprime de la base de donnees !");
    }

    @DeleteMapping("/purge")
    public void deleteAll() {
        contactRepository.deleteAll();
        log.info("Base contenant les messages purge !");
    }
}
