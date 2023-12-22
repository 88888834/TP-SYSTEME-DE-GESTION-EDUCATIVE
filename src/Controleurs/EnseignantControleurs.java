package Controleurs;
import Entitées.*;

import java.sql.*;
import java.util.*;
import  Services.*;
import database.Database;
import Main.Main;
public class EnseignantControleurs {

    public static void showMenu() throws SQLException, ClassNotFoundException {
        System.out.println("-------------------------[ Enseignants ]---------------------------");


        System.out.println("1: Pour afficher un enseignant");
        System.out.println("2: Pour ajouter les enseignants");
        System.out.println("3: Pour modifier un enseignant");
        System.out.println("4: Pour supprimer un enseignant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                showEnseignants();
                break;
            case 2:
                createEnseignant();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static List<String> getEnseignant(int id) {
        List<Enseignants> enseignantsList = Database.enseignants;
        String[] enseignantArray = new String[enseignantsList.size()];
        for (int i = 0; i < enseignantsList.size(); i++) {
            enseignantArray[i] = enseignantsList.get(i).getNom() + " " + enseignantsList.get(i).getPrenom();
        }
        return List.of(enseignantArray);
    }

//    public static void showEnseignants() {
//        for (Enseignants enseignant : Database.enseignants) {
//            System.out.print("Id : " + enseignant.getId());
//            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
//            System.out.print(" | Email : " + enseignant.getEmail());
//
//            String[] enseignantInfo = getEnseignant().toArray(new String[0]);
//            if (enseignantInfo != null) {
//                String enseignantNomPrenom = enseignant.getNom() + " " + enseignant.getPrenom();
//                for (int j = 0; j < enseignantInfo.length; j++) {
//                    if (enseignantNomPrenom.equals(enseignantInfo[j])) {
//                        System.out.print(" | Chef : " + enseignantInfo[j]);
//                        break;
//                    }
//                }
//            }}}
public static void showEnseignants() throws SQLException, ClassNotFoundException {
        List<Enseignants> enseignants=EnseignantService.getAllEns();
        if(enseignants.isEmpty()){
            System.out.println("enseignant non trouvable");
        }
        else {
            for(Enseignants   enseignant:enseignants) {
                System.out.println("id"+enseignant.getId()+"nom"+enseignant.getNom()+"prenom"+enseignant.getPrenom()+"email"+enseignant.getEmail()+"grade"+enseignant.getGrade()+"Departementid"+enseignant.getDepartement());
            }
        }
        showMenu();
}
    public static  void createEnseignant() throws SQLException, ClassNotFoundException {
        String nom = Main.getStringInput("Entrez nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez email :");
        int grade = Main.getIntInput("Entrez le grade :");
        int departement = Main.getIntInput("Entrez departement id :");
        EnseignantService.addEns(nom,prenom,email,grade,departement);
        System.out.println("Enseignant created successfully");
    }

    public static boolean exists(int id) {
        ///i should use select to search if the teacher id in the table departement
        return false;
    }


    public static void editEnseignant() throws SQLException, ClassNotFoundException {
        showEnseignants();
        Enseignants enseignant;
        enseignant = new Enseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez le email :");
        String grade = Main.getStringInput("Entrez le grade :");

        EnseignantControleurs.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        Departements dept = new Departements();

        EnseignantService.updateEns(id, nom, prenom, email, grade, dept);
        showEnseignants();
        showMenu();
    }
    public static void destroyEnseignant() throws SQLException, ClassNotFoundException {
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        EnseignantService.deleteEnsById( id);
        showEnseignants();
    }

}