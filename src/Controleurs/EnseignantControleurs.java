package Controleurs;
import Entitées.*;

import java.sql.*;
import java.util.*;
import  Services.*;
import database.Database;
import Main.Main;
public class EnseignantControleurs {

    public static void showMenu() throws SQLException, ClassNotFoundException {
        System.out.println("-------------------------[ Teachers ]---------------------------");


        System.out.println("1: To show teachers");
        System.out.println("2: to create a teacher");
        System.out.println("3: To modify a teacher");
        System.out.println("4: To delete a teacher");
        System.out.println("0: Return to the   principal menu");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Enter the option number:");
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
                System.out.println("there is n no teacher with thoseb characteristics ");
            } else {
                for (String enseignant : enseignants) {
                    System.out.println(enseignant);
                }
            }
        } catch (SQLException e) {
            System.out.println("  Error  : " + e.getMessage());
        }
    }


    public static  void createEnseignant() throws SQLException, ClassNotFoundException {
        String nom = Main.getStringInput("Enter last name :");
        String prenom = Main.getStringInput("Enter first name :");
        String email = Main.getStringInput("Enter email :");
        int grade = Main.getIntInput(          "Enter score :");
        int departement = Main.getIntInput("Enter departement id :");
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
        int id = Main.getIntInput("Select teacher by id:");
        String nom = Main.getStringInput("Enter last name :");
        String prenom = Main.getStringInput("Enter first name:");
        String email = Main.getStringInput("Enter email :");
        String grade = Main.getStringInput("Enter score :");

        EnseignantControleurs.showEnseignants();
        int idEns = Main.getIntInput("Select teacher by id:");

        Departements dept = new Departements();

        EnseignantService.updateEns(id, nom, prenom, email, grade, dept);
        showEnseignants();
        showMenu();
    }
    public static void destroyEnseignant() throws SQLException, ClassNotFoundException {
        showEnseignants();
        int id = Main.getIntInput("Select teacher by id:");
        EnseignantService.deleteEnsById( id);
        showEnseignants();
        showMenu();
    }

}