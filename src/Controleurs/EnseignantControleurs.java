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



        public static Enseignants getEnseignant(int id) {
            for (Enseignants enseignant : Database.enseignants) {
                if (enseignant.getId() == id) {
                    return enseignant;
                }
            }
            return null;
        }



    public static void showEnseignants() {
        try {
            List<String> enseignants = EnseignantService.showEns();
            if (enseignants.isEmpty()) {
                System.out.println("Aucun enseignant trouvé.");
            } else {
                for (String enseignant : enseignants) {
                    System.out.println(enseignant);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des enseignants : " + e.getMessage());
        }
    }


    public static  void createEnseignant() throws SQLException, ClassNotFoundException {
        String nom = Main.getStringInput("Entrez nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez email :");
        int grade = Main.getIntInput("Entrez le grade :");
        int departement = Main.getIntInput("Entrez departement id :");
        EnseignantService.addEns(nom,prenom,email,grade,departement);
        System.out.println("Enseignant created successfully");
        showMenu();
    }

    public static boolean exists(int id) {
        ///i should have used select to search if the teacher id in the table departement but i used another method tp know if the teacher exists.
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
        showMenu();
    }

}