package Services;

import Entitées.*;
import database.Database;
import java.util.ArrayList;
public class ModuleService {


//        public static  Modules addMod(int id, String mdescrip,String enseignant){
//            return  new  Modules();
//        }
//
//        public static  Modules updateMod(int id, String mdescrip,String enseignant ){
//            Modules updatedModules = new Modules();
//            // ... other code ...
//            return updatedModules;
//        }
//        public static ArrayList<Modules> deleteModById(int id) {
//            return  Database.modules;
//        }
//
//        public static Modules getModById(int id){
//            for ( Modules modules : Database.modules) {
//                if (modules.getId() == id) return modules;}
//
//               return  new  Modules();
//        }
//        public static ArrayList< Modules>    getAllMod(){
//            return  Database.modules;
//        }
public static Modules addMod(int id, String mdescrip, String enseignant) {
    Modules newModule = new Modules(id, mdescrip, enseignant); // Assuming Modules constructor takes id, description, enseignant
    Database.modules.add(newModule); // Assuming Database.modules is a List that can be added to
    return newModule;
}


    public static Modules updateMod(int id, String mdescrip, String enseignant) {
        for (Modules module : Database.modules) {
            if (module.getId() == id) {
                module.setMdescrip(mdescrip);
                module.setEnseignant(enseignant); // Assuming Modules has setDescription and setEnseignant methods
                return module;
            }
        }
        return null; // or throw an exception if the module is not found
    }

    public static boolean deleteModById(int id) {
        return Database.modules.removeIf(module -> module.getId() == id); // removeIf returns a boolean
    }
//    public void destroyModule() {
//        int id = Integer.parseInt(Main.getInput("Select a module by ID: "));
//        boolean success = Database.deleteModuleById(id); // Method to delete a module by ID
//
//        if (success) {
//            System.out.println("Module deleted successfully.");
//        } else {
//            System.out.println("Module could not be deleted.");
//        }
//    }


// getModById seems correct, assuming Database.modules is an iterable list of Modules and Modules class has a getId method.

// getAllMod is correct assuming Database.modules is the correct data structure containing all modules.

}


