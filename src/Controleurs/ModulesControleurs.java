
package Controleurs;
import Entitées.*;
import  Services.*;
import Main.Main;
import database.Database;

import java.sql.SQLException;
import java.util.List;




import java.sql.SQLException;
import java.util.List;

public class ModulesControleurs {


        public static void showMenu() throws SQLException, ClassNotFoundException {
            System.out.println("********************[ Modules ]*************************");


            System.out.println("1: Show modules");
            System.out.println("2: Create module ");
            System.out.println("3: Modify module");
            System.out.println("4: Delete module");
            System.out.println("0: Go to the principal menu");

            //"Veuillez sélectionner une option : ")
                 int option = Main.getIntInput("Enter the option number: ");
            switch(option) {
                case 1:
                    showModules();
                    break;
                case 2:
                    createModule();
                    break;
                case 3:
                    editModule();
                    break;
                case 4:
                    destroyModule();
                    break;
                default:
                    Main.showPrincipalMenu();
            }
        }
        public static String[] getModule() {
            List<Modules> modulesList = Database.modules;
            String[] modulesArray = new String[modulesList.size()];
            for (int i = 0; i < modulesList.size(); i++) {
                modulesArray[i] = modulesList.get(i).getMdescrip() + " " + modulesList.get(i).getEnseignant()+" "
                        +modulesList.get(i).getId()+". ";
            }
            return  modulesArray;
        }

        public static void showModules() throws SQLException, ClassNotFoundException {
            for (Modules modules : Database.modules) {
                System.out.print("Id : " + modules.getId());
                System.out.print(" | Description : " + modules.getMdescrip() );
                System.out.print(" | teacher : " + modules.getEnseignant());

                String[] modulesInfo = getModule();
                if (modulesInfo != null) {
                    String moduleIdDesriptionEnseignant = modules.getId() + " " + modules.getMdescrip()+ " "
                            + modules.getEnseignant();
                    for (int j = 0; j < modulesInfo.length; j++) {
                        if (moduleIdDesriptionEnseignant.equals(modulesInfo[j])) {
                            System.out.print(" | Module : " + modulesInfo[j]);
                            break;
                        }
                    }
                }
            }

            showMenu();
        }


        public static  void createModule() throws SQLException, ClassNotFoundException {
                  int id = Main.getIntInput("Enter id :");
            String mdescrip = Main.getStringInput("Enter description :");
            String enseignant  = Main.getStringInput("Enter teacher :");
            ModuleService.addMod(id,  mdescrip,enseignant);
            Controleurs.EtudiantControleurs.showEtudiants();

            System.out.println("Etudiant created successfully.");
            showModules();
            showMenu();
        }





        public static void editModule() throws SQLException, ClassNotFoundException {
            showModules();
                Modules module;
            module = new Modules();
            int id = Main.getIntInput("Select module by id:");
            String mdescrip = Main.getStringInput("Enter description :");
            String enseignant = Main.getStringInput("Enter teacher:");

            Controleurs.ModulesControleurs.showModules();
            Controleurs.EtudiantControleurs.createEtudiant();

            ModuleService.updateMod( id, mdescrip, enseignant);
            showModules();
            showMenu();
        }
        public static void destroyModule() throws SQLException, ClassNotFoundException {
            showModules();

                int id =  Main.getIntInput("Select a module by ID: ");
                boolean success = ModuleService.deleteModById(id); // Method to delete a module by ID

                if (success) {
                    System.out.println("Module deleted successfully.");
                } else {
                    System.out.println("Module could not be deleted.");
                }

            ModuleService.deleteModById( id);
            showModules();
            showMenu();
        }
    }


