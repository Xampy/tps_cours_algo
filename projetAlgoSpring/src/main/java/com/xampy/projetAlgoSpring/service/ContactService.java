package com.xampy.projetAlgoSpring.service;

import com.xampy.projetAlgoSpring.dao.ContactRepositoryInterface;
import com.xampy.projetAlgoSpring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @class ContactService
 */
@Service
public class ContactService implements ContactServiceInterface{

    private final ContactRepositoryInterface contactRepository;

    @Autowired
    public ContactService(ContactRepositoryInterface contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public Contact saveContact(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public List<Contact> listContact(int page) {
        return this.contactRepository
                .findAll(PageRequest.of(page, 10))
                .getContent();
    }

    @Override
    @Transactional
    public Contact updateContact(Long contactId, Contact updatedContact) {
        this.contactRepository.findById(contactId)
                .ifPresent(
                        contact -> {
                            contact.setEmail(updatedContact.getEmail());
                            contact.setNom(updatedContact.getNom());
                            contact.setPrenoms(updatedContact.getPrenoms());
                            contact.setSexe(updatedContact.getSexe());
                            contact.setTelephone(updatedContact.getTelephone());

                            this.contactRepository.save(contact);
                        }
                );
        return updatedContact;
    }

    @Override
    public Contact getContact(Long id) {
        Optional<Contact> c =  this.contactRepository.findById(id);
        return c.orElse(null);
    }

    @Override
    public void deleteContact(Long id) {
        this.contactRepository.findById(id)
                .ifPresent(this.contactRepository::delete);
    }
}
