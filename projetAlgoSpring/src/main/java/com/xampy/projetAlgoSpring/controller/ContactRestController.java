package com.xampy.projetAlgoSpring.controller;

import com.xampy.projetAlgoSpring.dto.ContactRequest;
import com.xampy.projetAlgoSpring.dto.ContactResponse;
import com.xampy.projetAlgoSpring.model.Contact;
import com.xampy.projetAlgoSpring.service.ContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
public class ContactRestController {

    private final ContactServiceInterface contactService;

    @Autowired
    public ContactRestController(ContactServiceInterface contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactResponse> saveContact(@RequestBody ContactRequest body){
        Contact c = body.toContact();

        c = this.contactService.saveContact(c);
        ContactResponse response = c.toContactResponse();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> saveContact(
            @PathVariable("id") Long contactId,  @RequestBody ContactRequest body){
        Contact c = body.toContact();

        c = this.contactService.updateContact(contactId, c);
        ContactResponse response = c.toContactResponse();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getContact(@PathVariable("id") Long contactId){

        Contact c = this.contactService.getContact(contactId);
        ContactResponse response = null;
        if (c != null) {
            response = c.toContactResponse();
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getContactsList(
            @RequestParam(value = "page", defaultValue = "1") Integer page){

        List<Contact> cs = this.contactService.listContact(page);
        List<ContactResponse> response = cs.stream()
                .map(Contact::toContactResponse)
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("id") Long contactId){
        this.contactService.deleteContact(contactId);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
