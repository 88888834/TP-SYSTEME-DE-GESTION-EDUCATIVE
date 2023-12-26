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


        System.out.println("1: To show Deaprtements");
        System.out.println("2: to create a departement");
        System.out.println("3: To modify a departement");
        System.out.println("4: To delete a departement");
        System.out.println("0: Return to the   principal menu");


        int option = Main.getIntInput(("Enter the option number : "));
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
/// create departement
    private static void creerdep() throws SQLException, ClassNotFoundException {

        String descrip = Main.getStringInput("Entrez description :");

        List<String> enseignant = Arrays.asList();

        String ens = Main.getStringInput("Entrez teacher  :");
        try {

            DepartementService DepartmentService = new DepartementService();
            Departements newDepartment = DepartmentService.addDept( descrip,enseignant );


            System.out.println("Department created successfully with ID: " + newDepartment.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        afficherDeps();
        showMenu();
    }



    ///this method show us all departmenets in departmenets database
    public static void afficherDeps() throws SQLException, ClassNotFoundException {
        try {
            List<String> departments = DepartementService.showDep();
            for (String department : departments) {
                System.out.println(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to display departments.");
        }
        
        showMenu();
    }


        public static void updateDepartment() throws SQLException, ClassNotFoundException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Department ID to update:");
            int depId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter new description for the department:");
            String newDescription = scanner.nextLine();

            System.out.println("Enter the full name of the teacher:");
            String fullName = scanner.nextLine();

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

            afficherDeps();
            showMenu();
        }




    public static void detruireDep() throws SQLException, ClassNotFoundException {

        afficherDeps();
            int id = Main.getIntInput("Select departement by id:");
            boolean deleted = DepartementService.deleteDeptById(id);
            if (deleted) {
                System.out.println("Departement has been deleted successfully");
            } else {
                System.out.println("Error while deleting Departement ");
            }
        afficherDeps();
        showMenu();
    }


}
