package Controleurs;
import Entitées.*;
import  Services.*;
import Main.Main;
import database.Database;

import java.sql.SQLException;
import java.util.List;

import static database.Database.filieres;

public class EtudiantControleurs {

    public static void showMenu() throws SQLException, ClassNotFoundException {
        System.out.println("********************[ Etudiants ]*************************");


        System.out.println("1: Show etudiants");
        System.out.println("2: Create etudiant ");
        System.out.println("3: Modify etudiant");
        System.out.println("4: Delete etudiant");
            System.out.println("0: Go to the principal menu");


        int option = Main.getIntInput("Enter the option number: ");
        switch(option) {
            case 1:
                showEtudiants();
                break;
            case 2:
                createEtudiant();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static String[] getEtudiant() {
        List<Etudiants> etudiantsList = Database.etudiants;
        String[] etudiantsArray = new String[etudiantsList.size()];
        for (int i = 0; i < etudiantsList.size(); i++) {
            etudiantsArray[i] = etudiantsList.get(i).getNom() + " " + etudiantsList.get(i).getPrenom()+" "+etudiantsList.get(i).getEmail()+". ";
        }
        return  etudiantsArray;
    }

    public static void showEtudiants() throws SQLException, ClassNotFoundException {
        for (Etudiants etudiant : Database.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | name : " + etudiant.getNom() + " " + etudiant.getPrenom());
            System.out.print(" | Email : " + etudiant.getEmail());

            String[] etudiantInfo = getEtudiant();
            if (etudiantInfo != null) {
             String etudiantNomPrenom = etudiant.getNom() + " " + etudiant.getPrenom();
                for (int j = 0; j < etudiantInfo.length; j++) {
                    if (etudiantNomPrenom.equals(etudiantInfo[j])) {
                        System.out.print(" | Etudiant : " + etudiantInfo[j]);
                        break;
                    }
                }
            }
        }

        showMenu();
    }

    public static  void createEtudiant() throws SQLException, ClassNotFoundException {
        String nom = Main.getStringInput("Entrez nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez le email :");
        EtudiantService.addEtud(nom,  prenom,email);
        EtudiantControleurs.showEtudiants();

        System.out.println("Etudiant created  successfully");
        showEtudiants();
        showMenu();
    }




    public static void editEtudiant() throws SQLException, ClassNotFoundException {
        showEtudiants();
        Etudiants etudiants;
        etudiants = new Etudiants();
        int id = Main.getIntInput("Select student by id :");
        String nom = Main.getStringInput("Enter  last name:");
        String prenom = Main.getStringInput("Enter first name:");
        String email = Main.getStringInput("Enter Email :");


        EtudiantControleurs.showEtudiants();
        int idetud = Main.getIntInput("Select student by id :");

        Filieres filieres = new Filieres();
        // ... other code to initialize the Departements object ...

        EtudiantService.updateEtud( nom, prenom, email);
        showEtudiants();
        showMenu();
    }
    public static void destroyEtudiant() throws SQLException, ClassNotFoundException {
        showEtudiants();
        int id = Main.getIntInput("Select student by id :");
        EtudiantService.deleteEtudById( id);
        showEtudiants();
        showMenu();
    }
}
