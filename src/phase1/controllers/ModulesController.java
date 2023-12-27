package phase1.controllers;

import phase1.Main;
import phase1.models.Module;
import phase1.services.*;


public class ModulesController {
    public static void showMenu() {
        System.out.println("-------------------------[ Modules ]---------------------------");


        System.out.println("1: Pour ajouter un module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier un module");
        System.out.println("4: Pour supprimer un module");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createModule();
                break;
            case 2:
                showModules();
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

    public static void showModules() {
        for (Module module: DB.modules) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | intitule: " + module.getIntitule());
            System.out.print(" | chef: " + module.getChef());
            System.out.print(" | filiere: " + module.getFiliere());
            System.out.println("");
        }
    }

    public static void createModule() {
        String intitule = Main.getStringInput("Entrez l'intitule':");
        EnseignantsController.showEnseignants();
        int idE = Main.getIntInput("Sélecionnez un enseignant par id :");
        FilieresController.showFilieres();
        int idF = Main.getIntInput("Sélecionnez une filiere par id :");
        ModuleServices.addModule(intitule, EnseignantServices.getEnsById(idE),FiliereServices.getFiliereById(idF));
        showModules();
        showMenu();
    }
    public static void editModule(){
        showModules();
        int id = Main.getIntInput("Sélecionnez un module par id :");
        String intitule = Main.getStringInput("Entrez l'intitule':");
        EnseignantsController.showEnseignants();
        int idE = Main.getIntInput("Sélecionnez un enseignant par id :");
        FilieresController.showFilieres();
        int idF = Main.getIntInput("Sélecionnez une filiere par id :");
        ModuleServices.updateModule(id,intitule,EnseignantServices.getEnsById(idE),FiliereServices.getFiliereById(idF));
        showModules();
        showMenu();
    }
    public static void destroyModule(){
        showModules();
        int id = Main.getIntInput("Sélecionnez un module par id :");
        ModuleServices.deleteModuleById(id);
        showModules();
    }
}

