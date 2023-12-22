package Entitées;

import java.util.ArrayList;
import java.util.List;
public class Enseignants {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private int grade;
    private boolean isEnseignant;

    private int   departement;
    private List<Modules>  modules;
    public  Enseignants() {

    }
    public  Enseignants(String nom, String prenom,String email,int grade, int departement) {
//        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email=email;
        this.grade=grade;
        this.departement=departement;
    }
    public  Enseignants(String nom, String prenom,String email,int grade) {
        this.nom = nom;
        this.prenom = prenom;
        this.email=email;
        this.grade=grade;

    }
    public  Enseignants(String prenom, String nom) {

        this.nom = nom;
        this.prenom = prenom;

    }
    public  Enseignants(Integer id,String nom) {
        this.id=id;
        this.nom = nom;

    }
    public  Enseignants(Integer id,String nom, String prenom,String email,int grade,Modules modules) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email=email;
        this.grade=grade;
        this.modules=new ArrayList<>();
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
    }

    public void setModules(List<Modules> modules) {
        this.modules = modules;
    }

    public int getDepartement() {
        return departement;
    }

    public List<Modules> getModules() {
        return modules;
    }

    public boolean isEnseignant(Enseignants enseignants) {
        return isEnseignant;
    }
}
