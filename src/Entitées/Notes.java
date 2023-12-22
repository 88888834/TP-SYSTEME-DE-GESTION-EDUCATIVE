package Entitées;


public class Notes {
    private int valeur;
    private String filieres;
    private String etudiants;
    public  Notes() {}
    public  Notes(int valeur,String filieres) {

        this.valeur=valeur;
        this.filieres=filieres;

    }
    public  Notes(int valeur,String filieres,String etudiants) {

        this.valeur=valeur;
        this.filieres=filieres;
        this.etudiants= etudiants;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public String getFilieres() {
        return filieres;
    }

    public void setFilieres(String filieres) {
        this.filieres = filieres;
    }

    public String getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(String etudiants) {
        this.etudiants = etudiants;
    }
}
