package com.xampy.projetAlgoSpring.dto;

import com.xampy.projetAlgoSpring.model.Contact;

public class ContactRequest {
    private String nom;
    private String prenoms;

    private String sexe;

    private String telephone;

    private String email;

    public ContactRequest() {
    }

    public ContactRequest(String nom, String prenoms, String sexe, String telephone, String email) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.sexe = sexe;
        this.telephone = telephone;
        this.email = email;
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

    public Contact toContact(){
        Contact c = new Contact();
        c.setNom(this.getNom());
        c.setPrenoms(this.getPrenoms());
        c.setSexe(this.getSexe());
        c.setTelephone(this.getTelephone());
        c.setEmail(this.getEmail());

        return c;
    }
}
