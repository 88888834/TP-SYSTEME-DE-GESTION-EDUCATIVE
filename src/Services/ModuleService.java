package Services;

import Entitées.*;
import database.Database;
import java.util.ArrayList;
public class ModuleService {


public static Modules addMod(int id, String mdescrip, String enseignant) {
    Modules newModule = new Modules(id, mdescrip, enseignant);
    Database.modules.add(newModule);
    return newModule;
}


    public static Modules updateMod(int id, String mdescrip, String enseignant) {
        for (Modules module : Database.modules) {
            if (module.getId() == id) {
                module.setMdescrip(mdescrip);
                module.setEnseignant(enseignant);
                return module;
            }
        }
        return null;
    }

    public static boolean deleteModById(int id) {
        return Database.modules.removeIf(module -> module.getId() == id); // removeIf returns a boolean
    }


}


