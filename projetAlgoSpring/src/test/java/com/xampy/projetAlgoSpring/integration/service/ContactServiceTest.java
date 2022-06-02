package com.xampy.projetAlgoSpring.integration.service;

import com.xampy.projetAlgoSpring.dao.ContactRepositoryInterface;
import com.xampy.projetAlgoSpring.model.Contact;
import com.xampy.projetAlgoSpring.service.ContactServiceInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties"
)
class ContactServiceTest {

    @Autowired
    private ContactRepositoryInterface contactRepository;

    @Autowired
    private ContactServiceInterface contactService;

    @AfterEach
    void tearDown(){
        this.contactRepository.deleteAll();
    }

    @Test
    void saveContact() {
        //Given
        String nom = "nom";
        String prenoms = "prenoms";
        String sexe = "sexe";
        String telephone = "telephone";
        String email = "email";
        Contact c = new Contact(null, nom, prenoms, sexe, telephone, email);

        //When
        this.contactService.saveContact(c);

        //Then
        assertNotNull(c.getContactId());
        assertTrue(this.contactRepository.findById(c.getContactId()).isPresent());
    }

    @Test
    void listContact() {
        //Given
        String nom = "nom";
        String prenoms = "prenoms";
        String sexe = "sexe";
        String telephone = "telephone";
        String email = "email";
        Contact c = new Contact(null, nom, prenoms, sexe, telephone, email);
        this.contactService.saveContact(c);

        //When
        List<Contact> contactsList = this.contactService.listContact(1);

        //Then
        assertEquals(1, contactsList.size());
        assertEquals(nom, contactsList.get(0).getNom());
    }

    @Test
    void updateContact() {
    }

    @Test
    void getContact() {
    }

    @Test
    void deleteContact() {
    }
}