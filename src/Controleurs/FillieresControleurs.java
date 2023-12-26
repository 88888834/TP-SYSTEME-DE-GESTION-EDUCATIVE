package Controleurs;
import Entitées.*;

import java.sql.SQLException;
import java.util.*;
import  Services.*;
import database.Database;
import Main.Main;
public class FillieresControleurs {
    public static void showMenu() throws SQLException, ClassNotFoundException {
        System.out.println("-------------------------[ Sector ]---------------------------");


        System.out.println("1: To show sectors");
        System.out.println("2: to create a sector");
        System.out.println("3: To modify a sector");
        System.out.println("4: To delete a sector");
        System.out.println("0: Return to the   principal menu");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Enter the option number: ");
        switch(option) {
            case 1:
                showFilliere();
                break;
            case 2:
                createFilliere();
                break;
            case 3:
                editFilliere();
                break;
            case 4:
                destroyFilliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static String[] getFiliere() {
        List<Filieres> filieresList = Database.filieres;
        String[] filiereArray = new String[filieresList.size()];
        for (int i = 0; i < filieresList.size(); i++) {
            filiereArray[i] = filieresList.get(i).getFid() + " " + filieresList.get(i).getFdesc();
        }
        return filiereArray;
    }
    public static void showFilliere() {
        for (Filieres filieres : Database.filieres) {

             System.out.print("Id : " + filieres.getFid());
            System.out.print(" | Description : " + filieres.getFdesc());

              String[] filieresInfo = getFiliere();
            if (filieresInfo != null) {
                String enseignantIdDescription = filieres.getFid() + " " + filieres.getFdesc();
                for (int j = 0; j < filieres.length; j++) {
                    if (enseignantIdDescription.equals(filieresInfo[j])) {
                        System.out.print(" | Chef : " + filieresInfo[j]);
                        break;
                    }
                }
            }}}
    public static  void createFilliere() {
        String fdesc = Main.getStringInput("Enter description :");
        FillieresControleurs.showFilliere();

        System.out.println("Sector created successfully");
        showFilliere();
    }

    public static void editFilliere() throws SQLException, ClassNotFoundException {
        showFilliere();
        Filieres filieres;
        filieres = new Filieres();
        int fid = Main.getIntInput("Select teacher by id:");
        String fdesc = Main.getStringInput("Enter description :");


        showFilliere();
        int idEns = Main.getIntInput("Select teacher by id:");

        Enseignants enseignant=new Enseignants();

        FilliereService.updateFill( fid,  fdesc,  enseignant);

        showFilliere();
        showMenu();
    }
    public static void destroyFilliere(){
        showFilliere();
        int fid = Main.getIntInput("Select sector by id:");
        FilliereService.deleteFillById(fid);
        showFilliere();
    }


}
