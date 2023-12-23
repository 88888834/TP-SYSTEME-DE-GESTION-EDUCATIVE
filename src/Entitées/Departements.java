package Entitées;

import java.util.ArrayList;
import java.util.List;

public class Departements {

    private int id;
    private String descrip;
    private List<String> enseignant;
    private List<Filieres> filieres;

    public  Departements() {}

    public Departements(int  id ,List<String> enseignant,Filieres filieres,String descrip){
        this.id=id;
//        this.enseignant=enseignant;
        this.descrip=descrip;
        this.filieres=new ArrayList<>();
        this.enseignant=new  ArrayList<>();
    }
    public Departements(int  id ,String descrip){
        this.id=id;
        this.descrip=descrip;
        this.filieres=new ArrayList<>();

    }
    public Departements(int id ,List<String>  enseignant){
        this.id=id;

        this.enseignant=enseignant;

    }
    public Departements(int id ){
        this.id=id;


    }

    public int getId() {
        return id;
    }

    public List<String>  getEnseignant() {
                                      return enseignant;
    }



    public String getDescrip() {
        return descrip;
    }


    public void setEnseignant(List<String>   enseignant) {
        this.enseignant = enseignant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setFilieres(List<Filieres> filieres) {
        this.filieres = filieres;
    }

}



