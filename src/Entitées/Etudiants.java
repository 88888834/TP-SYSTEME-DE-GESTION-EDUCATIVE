package Entitées;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etudiants {
    public int length;
    private String nom;
    private String prenom;
    private String email;
    private int id;
    private Filieres filieres;
    private Map<Modules, Double> notes;

    public  Etudiants() {}
    public  Etudiants(String nom, String prenom,String email,int id,Filieres filieres) {
        this.nom = nom;
        this.prenom = prenom;
        this.email=email;
        this.id=id;
        this.filieres=filieres;
        this.notes = new HashMap<>();
    }
    public  Etudiants(String nom, String prenom,String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email=email;

        this.notes = new HashMap<>();
    }
    public Map<Modules, Double>  getNotes() {
        return notes;
    }

    public void setNotes(Map<Modules, Double>  notes) {
        this.notes = notes;
    }

    public Filieres getFilieres() {
        return filieres;
    }

    public void setFilieres(Filieres filieres) {
        this.filieres = filieres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
