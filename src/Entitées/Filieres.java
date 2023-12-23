package Entitées;


import java.util.ArrayList;
import java.util.List;

public class Filieres {
    public int length;
    private int fid;
    private String fdesc;
    private Enseignants enseignant ;
    private List<Module> modules;
    public Filieres() {

    }
    public Filieres(int fid, String fdesc,Enseignants enseignant) {
        this.fid = fid;
        this.fdesc=fdesc;
        this.enseignant = enseignant;

        this.modules=new ArrayList<Module>();
    }
    public Filieres(int fid, String fdesc){
        this.fid = fid;
        this.fdesc=fdesc;
    }
    public Filieres(int fid) {
        this.fid = fid;

        this.modules=new ArrayList<Module>();
    }


    public List<Module> getModules() {
        return modules;
    }

    public int getFid() {
        return fid;
    }

    public Enseignants getEnseignant() {
        return enseignant;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public void setEnseignant(Enseignants enseignant) {
        this.enseignant = enseignant;
    }

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }



}
