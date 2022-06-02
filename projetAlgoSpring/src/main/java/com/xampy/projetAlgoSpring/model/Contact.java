package com.xampy.projetAlgoSpring.model;

import com.xampy.projetAlgoSpring.dto.ContactResponse;

import javax.persistence.*;

@Entity
@Table(name = "contact_table")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;

    @Column(columnDefinition = "varchar(45)")
    private String nom;

    @Column(columnDefinition = "varchar(45)")
    private String prenoms;

    @Column(columnDefinition = "varchar(45)")
    private String sexe;

    @Column(columnDefinition = "varchar(45)")
    private String telephone;

    @Column(columnDefinition = "varchar(45)")
    private String email;

    public Contact() {
    }

    public Contact(Long contactId, String nom, String prenoms, String sexe, String telephone, String email) {
        this.contactId = contactId;
        this.nom = nom;
        this.prenoms = prenoms;
        this.sexe = sexe;
        this.telephone = telephone;
        this.email = email;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactResponse toContactResponse(){
        ContactResponse response = new ContactResponse();
        response.setContactId(this.getContactId());
        response.setNom(this.getNom());
        response.setPrenoms(this.getPrenoms());
        response.setSexe(this.getSexe());
        response.setTelephone(this.getTelephone());
        response.setEmail(this.getEmail());

        return response;
    }
}
