package Services;
import Entitées.*;
import database.Database;
import java.util.ArrayList;


public class EtudiantService {

    public static Etudiants addEtud(String nom, String prenom, String email){
        return  new Etudiants();
    }

    public static Etudiants updateEtud(String nom, String prenom, String email ){
        Etudiants updatedEtudiants = new Etudiants();
        // ... other code ...
        return updatedEtudiants;
    }
    public static ArrayList<Etudiants>   deleteEtudById(int id) {
        return  Database.etudiants;
    }

    public static Etudiants getEnsById(int id){
        for (Etudiants etudiants : Database.etudiants) {
            if (etudiants.getId() == id) return  etudiants;
        }
        return  new Etudiants();
    }
    public static ArrayList<Etudiants> getAllEtud(){
        return  Database.etudiants;
    }
}
