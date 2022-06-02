package com.xampy.projetAlgoSpring.dto;

public class ContactResponse {

    private Long contactId;
    private String nom;

    private String prenoms;

    private String sexe;

    private String telephone;

    private String email;

    public ContactResponse() {
    }

    public ContactResponse(Long contactId, String nom, String prenoms, String sexe, String telephone, String email) {
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
}
