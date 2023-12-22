package Entitées;

import java.util.ArrayList;
import java.util.List;
public class Modules {
    private int id;
    private String mdescrip;
    private List<Filieres>fillieres;
    private String enseignant;

    public Modules(int id, String mdescrip,String enseignant){
        this.id=id;
        this.fillieres=new ArrayList<>();
        this.enseignant=enseignant;
    }
    public Modules(){}
    public int getId(){
        return id;
    }

    public List<Filieres> getFillieres() {
        return fillieres;
    }
    public String getMdescrip() {
        return mdescrip;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setMdescrip(String mdescrip) {
        this.mdescrip=mdescrip;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }
}
