package phase1.services;

import phase1.models.Enseignant;
import phase1.models.Filiere;
import phase1.models.Module;

import java.util.ArrayList;

public class ModuleServices {

    public static Module addModule(String intitule, Enseignant chef,  Filiere filiere) {
        Module module = new Module();
        module.setIntitule(intitule);
        module.setChef(chef);
        module.setFiliere(filiere);
        DB.modules.add(module);
        return module;
    }

    public static Module updateModule(int id , String intitule, Enseignant chef,  Filiere filiere){
        for(Module module : DB.modules)
        {
            if(module.getId() == id)
            {
                module.setIntitule(intitule);
                module.setChef(chef);
                module.setFiliere(filiere);
                return module;
            }
        }
        return  new Module();
    }
    public static ArrayList<Module> deleteModuleById(int id){
        DB.modules.remove(getModuleById(id));
        return  DB.modules;
    }

    public static Module getModuleById(int id){
        for(Module module : DB.modules)
        {
            if(module.getId()== id) return module;
        }
        return  new Module();
    }

    public static ArrayList<Module> getAllModule(){
        return  DB.modules;
    }
}

