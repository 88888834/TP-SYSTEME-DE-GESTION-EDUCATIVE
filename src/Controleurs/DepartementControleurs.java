package Controleurs;
import Entitées.*;
import Controleurs.EnseignantControleurs;

import java.sql.SQLException;
import java.util.*;
import  Services.EnseignantService;
import  Services.DepartementService;
import database.Database;
import Main.Main;


public class DepartementControleurs {
    public static void showMenu() throws SQLException, ClassNotFoundException {
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput(("Veuillez sélectionner une option : "));
        switch(option) {
            case 1:
                creerdep();
                break;
            case 2:
                afficherDeps();
                break;
            case 3:
                updateDepartment();
                break;
            case 4:
                detruireDep();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    private static void creerdep() {
//        int id = Main.getIntInput("Sélectionnez un enseignant par id :");
        String descrip = Main.getStringInput("Entrez description :");

        List<String> enseignant = Arrays.asList(); // List of teacher names

        String ens = Main.getStringInput("Entrez enseignant  :");
        try {
            // Assuming the addDept method returns a Departements object
            DepartementService DepartmentService = new DepartementService();
            Departements newDepartment = DepartmentService.addDept( descrip,enseignant );

            // If the method is successful, newDepartment will be the created department object
            System.out.println("Department created successfully with ID: " + newDepartment.getId());
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the SQL exception appropriately
        }
    }



    public static void afficherDeps() {
        try {
            List<String> departments = DepartementService.showDep();
            for (String department : departments) {
                System.out.println(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to display departments.");
        }
    }


        public static void updateDepartment() throws SQLException, ClassNotFoundException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Department ID to update:");
            int depId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter new description for the department:");
            String newDescription = scanner.nextLine();

            System.out.println("Enter the full name of the teacher:");
            String fullName = scanner.nextLine();
            // Assuming the full name is in the format "Lastname Firstname"
            String[] nameParts = fullName.split(" ");
            String newNom = nameParts.length > 0 ? nameParts[0] : "";
            String newPrenom = nameParts.length > 1 ? nameParts[1] : "";

            try {
                DepartementService.updateDep(depId, newDescription, newNom, newPrenom);
                System.out.println("Department updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to update department.");
            }

            // Call other methods as required
            afficherDeps();
            showMenu();
        }



//    public static void editerDep() throws SQLException, ClassNotFoundException {
//        afficherDeps();
//        int id = Main.getIntInput("Sélecionnez un departement par id :");
//        String descrip = Main.getStringInput("Entrez l'intitulé :");
//        EnseignantControleurs.showEnseignants();
//        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");
//
////        DepartementService.majDept(id,EnseignantService.getEnsById(idEns),descrip);
//        afficherDeps();
//        showMenu();
//
//    }
    public static void detruireDep(){

        afficherDeps();
            int id = Main.getIntInput("Sélectionnez un département par id :");
            boolean deleted = DepartementService.deleteDeptById(id);
            if (deleted) {
                System.out.println("Département supprimé avec succès!");
            } else {
                System.out.println("Échec de la suppression du département.");
            }
        afficherDeps();

    }


}
