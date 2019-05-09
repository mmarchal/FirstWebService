package com.mmapps.pp.Services;

import com.mmapps.pp.Dto.ContactDto;
import com.mmapps.pp.Entity.Contact;
import com.mmapps.pp.Repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public boolean sendMessage(ContactDto contactDto)
    {

        if(contactDto.getNomValue() != null && contactDto.getMailValue()!=null && contactDto.getMessageValue()!= null)
        {
            try {
                Contact contactToSave = new Contact();
                contactToSave.setNomValue(contactDto.getNomValue());
                contactToSave.setMailValue(contactDto.getMailValue());
                contactToSave.setMessageValue(contactDto.getMessageValue());
                contactRepository.save(contactToSave);
                log.info("Message enregistre ! ");
                return true;
            }
            catch (Exception e) {
                log.info(e.getMessage());
                return false;
            }
        }
        else
        {
            log.info(contactDto.toString());
            log.info("Erreur lors de l'envoie ! ");
            return false;
        }

    }
}
