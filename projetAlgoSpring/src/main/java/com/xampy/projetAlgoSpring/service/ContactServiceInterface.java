package com.xampy.projetAlgoSpring.service;

import com.xampy.projetAlgoSpring.model.Contact;

import java.util.List;

public interface ContactServiceInterface {

    Contact saveContact(Contact contact);
    List<Contact> listContact(int page);
    Contact updateContact(Long contactId, Contact updatedContact);
    Contact getContact(Long id);
    void deleteContact(Long id);
}
